package com.falabella.transacciones.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falabella.transacciones.dao.QueryTransaccion;
import com.falabella.transacciones.models.Transaccion;
import com.falabella.transacciones.models.TrxDetails;
import com.falabella.transacciones.services.TransaccionService;

import utils.HashMapCodes;
import utils.IbmCommandCall;

@Service
public class TransaccionServiceImpl implements TransaccionService {

	private static final Logger log = LoggerFactory.getLogger(TransaccionServiceImpl.class);

	private final QueryTransaccion queryDao;

	@Autowired
	public TransaccionServiceImpl(QueryTransaccion queryDao) {
		this.queryDao = queryDao;
	}

	private static final String SQLGETTRANSACCIONES = "/sql/transacciones/get/getTransacciones.sql";

	@Override
	public List<Transaccion> getTransacciones(Integer fechaDesde, Integer fechaHasta, Integer horaDesde,
			Integer horaHasta, String bin, String ultimosDigitos, String rut,String appTrans) {
		Map<String, Object> params = new HashMap<>();
		params.put("fechaDesde", fechaDesde);
		params.put("fechaHasta", fechaHasta);
		params.put("horaDesde", horaDesde);
		params.put("horaHasta", horaHasta);
		params.put("bin", bin);
		params.put("ultimosDigitos", ultimosDigitos);
		params.put("rut", rut);
		params.put("appTrans", appTrans);
		List<Transaccion> transacciones = queryDao.findObjectsArray(SQLGETTRANSACCIONES, params, Transaccion.class)
				.collectList().block();
		Map<String, Object> tarjetas = new HashMap<>();
		transacciones.stream().filter(distinctByKey(Transaccion::getNumeroTarjetaTransaccion)).forEach(t -> tarjetas
				.put(t.getNumeroTarjetaTransaccion(), IbmCommandCall.callVpan(t.getNumeroTarjetaTransaccion())));

		/**
		 * Autorizadores : 
		 * SAT (Sistema de Crédito) 
		 * FLX (Sistema de cartera castigados)
		 * PYT (PayTrue) 
		 * GNG (GoGoNoGo) 
		 * STP (Sistema de avance)
		 */
		transacciones.stream().forEach(t -> {
			List<TrxDetails> trxDetails = new ArrayList<TrxDetails>();
			/**
			 * Logica que obtiene codigos de SAT de cualquier posicion
			 */

			if (t.getFillerEmisorTransaccion().contains("SAT")) {
				TrxDetails detail = new TrxDetails();
				int p = t.getFillerEmisorTransaccion().indexOf("SAT");
				String backend = t.getFillerEmisorTransaccion().substring(p, p + 3);
				String estado = t.getFillerEmisorTransaccion().substring(p + 3, p + 5);
				String codigo = t.getFillerEmisorTransaccion().substring(p + 5, p + 7);
				try {
					detail.setBackend(backend);
					detail.setEstado(estado);
					detail.setCodigo(codigo);
					detail.setDescripcion(t.getFillerEmisorTransaccion().substring(50, 53)+"-"+HashMapCodes.getListSAT().get(t.getFillerEmisorTransaccion().substring(50, 53)));
					trxDetails.add(detail);
				} catch (Exception e) {
					log.error("[SAT] Error getting code from SAT : {}", e.getMessage());
				}
			}

			/**
			 * Logica que obtiene codigos de FLX de cualquier posicion
			 */
			if (t.getFillerEmisorTransaccion().contains("FLX")) {
				TrxDetails detail = new TrxDetails();
				int p = t.getFillerEmisorTransaccion().indexOf("FLX");
				String backend = t.getFillerEmisorTransaccion().substring(p, p + 3);
				String estado = t.getFillerEmisorTransaccion().substring(p + 3, p + 5);
				String codigo = t.getFillerEmisorTransaccion().substring(p + 5, p + 7);
				try {
					detail.setBackend(backend);
					detail.setEstado(estado);
					detail.setCodigo(codigo);
					detail.setDescripcion(HashMapCodes.getListFLX().get(t.getFillerEmisorTransaccion().substring(p + 5, p + 7)));
					trxDetails.add(detail);
				} catch (Exception e) {
					log.error("[FLX] Error getting code from FLX : {}", e.getMessage());
				}
			}

			/**
			 * Logica que obtiene codigos de PYT de cualquier posicion
			 */
			if (t.getFillerEmisorTransaccion().contains("PYT")) {
				TrxDetails detail = new TrxDetails();
				int p = t.getFillerEmisorTransaccion().indexOf("PYT");
				String backend = t.getFillerEmisorTransaccion().substring(p, p + 3);
				String estado = t.getFillerEmisorTransaccion().substring(p + 3, p + 5);
				String codigo = t.getFillerEmisorTransaccion().substring(p + 5, p + 7);
				try {
					detail.setBackend(backend);
					detail.setEstado(estado);
					detail.setCodigo(codigo);
					detail.setDescripcion(HashMapCodes.getListPYT().get(t.getFillerEmisorTransaccion().substring(p + 5, p + 7)));
					trxDetails.add(detail);
				} catch (Exception e) {
					log.error("[PYT] Error getting code from PYT : {}", e.getMessage());
				}
			}

			/**
			 * Logica que obtiene codigos de GNG de cualquier posicion
			 */
			if (t.getFillerEmisorTransaccion().contains("GNG")) {
				TrxDetails detail = new TrxDetails();
				int p = t.getFillerEmisorTransaccion().indexOf("GNG");
				String backend = t.getFillerEmisorTransaccion().substring(p, p + 3);
				String estado = t.getFillerEmisorTransaccion().substring(p + 3, p + 5);
				String codigo = t.getFillerEmisorTransaccion().substring(p + 5, p + 7);
				try {
					detail.setBackend(backend);
					detail.setEstado(estado);
					detail.setCodigo(codigo);
					detail.setDescripcion(HashMapCodes.getListGNG().get(t.getFillerEmisorTransaccion().substring(p + 5, p + 7)));
					trxDetails.add(detail);
				} catch (Exception e) {
					log.error("[GNG] Error getting code from GNG : {}", e.getMessage());
				}
			}

			/**
			 * Logica que obtiene codigos de STP de cualquier posicion
			 */
//			if (t.getFillerEmisorTransaccion().contains("STP")) {
//				TrxDetails detail = new TrxDetails();
//
//				int p = t.getFillerEmisorTransaccion().indexOf("STP");
//				String backend = t.getFillerEmisorTransaccion().substring(p, p + 3);
//				String estado = t.getFillerEmisorTransaccion().substring(p + 3, p + 5);
//				String codigo = t.getFillerEmisorTransaccion().substring(p + 5, p + 7);
//				System.out.println("El codigo completo es : " + t.getFillerEmisorTransaccion());
//				try {
//					detail.setBackend(backend);
//					detail.setEstado(estado);
//					detail.setCodigo(codigo);
//					// detail.setDescripcion(t.getFillerEmisorTransaccion());
//					trxDetails.add(detail);
//					System.out.println("El detalle de la lista " + detail);
//					;
//				} catch (Exception e) {
//					log.error("[STP] Error getting code from STP : {}", e.getMessage());
//				}
//			}
			t.setTrxDetails(trxDetails);
		});
		
		this.convertEntryPos(transacciones);
		
		return transacciones;
	}

	private List<Transaccion> convertEntryPos(List<Transaccion> transacciones) {
		
		transacciones.stream().forEach(t -> {
			t.setEntryModePOS(t.getEntryModePOS()+"-"+HashMapCodes.getListEntryPos().get(t.getEntryModePOS()));
		});
		return transacciones;
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(keyExtractor.apply(t));
	}

}

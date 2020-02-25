package com.falabella.transacciones.dao;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import utils.SqlReader;

@Repository
public class QueryTransaccion {
	private static final Logger log = LoggerFactory.getLogger(QueryTransaccion.class);
	private final NamedParameterJdbcTemplate template;

	@Autowired
	public QueryTransaccion(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	public <T> Flux<T> findObjectsArray(String sqlPath, Map<String, Object> params, Class<T> clazz) {
		String dynamicSql = SqlReader.readSql(sqlPath);
		
		String schema = "AZBASWQA";
		if(schema != null) {
			dynamicSql += " FROM "+ schema +".AZLHT AS transaccion INNER JOIN " + schema+".ACCMT AS maestro_cuenta ON maestro_cuenta.CMTNUM = transaccion.LHTINT where ";
		}
			
		/**
		 * Valida si viene fecha desde y fecha hasta
		 */
		if (params.get("fechaDesde") != null && params.get("fechaHasta") != null) {
			dynamicSql += " (transaccion.LHTOFI between " + params.get("fechaDesde") + " and "
					+ params.get("fechaHasta") + ")";
		}
		
		/**
		 * Valida si viene hora desde y hora hasta
		 */
		if (params.get("horaDesde") != null && params.get("horaHasta") != null) {
			dynamicSql += " and (transaccion.LHTOHI between " + params.get("horaDesde") + " and "
					+ params.get("horaHasta") + ")";
		}
		
		/**
		 * Valida si viene el bin y los ultimos digitos
		 */
		if (params.get("bin") != null && params.get("ultimosDigitos") != null) {
			dynamicSql += " AND SUBSTR (transaccion.LHTINT, 1, 6) = '" + params.get("bin")
					+ "' AND SUBSTR (transaccion.LHTINT, 7, 4) = '" + params.get("ultimosDigitos") + "'";
		}
		
		/**
		 * Valida si viene el rut
		 */
		String rutConsultado = (String) params.get("rut");
		if(!rutConsultado.isEmpty()) {
			dynamicSql += " and replace(LTRIM(REPLACE(TRIM(maestro_cuenta.CMTCED), '0', ' ')), ' ', '0') =" +params.get("rut");
		}
		
		/**
		 * Valida si viene el nombre de la app
		 */
		
		String appTrans = (String) params.get("appTrans");
		if(!appTrans.isEmpty()) {
			dynamicSql += " and transaccion.LHTAPL in ( '" + params.get("appTrans") + "')";
		}
		

		log.info(dynamicSql);
		String sql = dynamicSql;
		return Flux.defer(() -> Flux.fromIterable(template.query(sql, params, new BeanPropertyRowMapper<>(clazz))))
				.subscribeOn(Schedulers.elastic());
	}
}

package com.falabella.transacciones.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.falabella.transacciones.models.Transaccion;
import com.falabella.transacciones.services.TransaccionService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class TransaccionController {

	
	private final TransaccionService transaccionService;

	public TransaccionController(TransaccionService transaccionService) {
		this.transaccionService = transaccionService;
	}
	
	@GetMapping(value = "/transaccion")
	public List<Transaccion> getTransaccion(
			@RequestHeader(value = "fechaDesde", required = true) Integer fechaDesde,
			@RequestHeader(value = "fechaHasta", required = true) Integer fechaHasta,
			@RequestHeader(value = "horaDesde", required = true) Integer horaDesde,
			@RequestHeader(value = "horaHasta", required = true) Integer horaHasta,
			@RequestHeader(value = "bin", required = false) String bin,
			@RequestHeader(value = "ultimosDigitos", required = false) String ultimosDigitos,
			@RequestHeader(value = "rut", required = false) String rut,
			@RequestHeader(value = "appTrans", required = false) String appTrans){
		return transaccionService.getTransacciones(fechaDesde, fechaHasta, horaDesde, horaHasta, 
				bin, ultimosDigitos, rut,appTrans);
	}
}

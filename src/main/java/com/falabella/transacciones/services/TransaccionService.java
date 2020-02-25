package com.falabella.transacciones.services;

import java.util.List;

import com.falabella.transacciones.models.Transaccion;

public interface TransaccionService {

	public List<Transaccion> getTransacciones(Integer fechaDesde, 
			Integer fechaHasta, Integer horaDesde, Integer horaHasta, String bin, String ultimosDigitos, String rut, String appTrans);
}

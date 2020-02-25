package com.falabella.transacciones.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TrxDetails {
	
	private String backend;
	private String estado;
	private String codigo;
	private String descripcion;

}

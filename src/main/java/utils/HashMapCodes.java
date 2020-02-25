package utils;

import java.util.HashMap;

public class HashMapCodes {

	public static HashMap<String, String> getListSAT() {
		HashMap<String, String> maps = new HashMap<>();
		maps.put("   ", "");
		maps.put("000", "Transacción aprobada.");
		maps.put("082", "Ultimo débito sin pérdida de reajuste");
		maps.put("100", "Denegada Retener Tarjeta. ");
		maps.put("101", "Denegada. ");
		maps.put("104", "No permitida la operación.");
		maps.put("106", "Denegada, Tarjeta Caducada.");
		maps.put("116", "No hay suficientes fondos.");
		maps.put("121", "Excedido Limite Diario Cajeros.");
		maps.put("130", "Tarjeta No Efectiva por Situación.");
		maps.put("131", "Tarjeta Bloqueada");
		maps.put("132", "Contrato Bloqueado.");
		maps.put("133", "Contrato Inactivo.");
		maps.put("135", "Compra Cuotas No Permitida.");
		maps.put("136", "Excedido número de operaciones Diario.");
		maps.put("137", "Excedido número de operaciones Mensual.");
		maps.put("138", "Tarjeta Dada de Baja.");
		maps.put("141", "Número de Cuotas Inferior al Mínimo.");
		maps.put("142", "Importe de Cuotas inferior al mínimo.");
		maps.put("143", "Importe de Cuotas superior al máximo");
		maps.put("145", "Denegada. Motivo antifraude");
		maps.put("146", "Fecha de Caducidad Errónea.");
		maps.put("147", "Número de Cuotas superior al máximo.");
		maps.put("148", "Error en el número de meses de carencia.");
		maps.put("150", "Operación no permitida al comercio.");
		maps.put("151", "Importe de la compra mayor que el máximo");
		maps.put("152", "Importe de la compra mayor que el mínimo");
		maps.put("180", "Datos de operación erróneos. ");
		maps.put("183", "Cliente perderá reajuste por débito en ahorro.");
		maps.put("201", "No permitida la operación de débito.");
		maps.put("202", "No permitida la operación de crédito.");
		maps.put("213", "Contrato dado de baja.");
		maps.put("214", "Tarjeta no activada.");
		maps.put("215", "Excedido número de operaciones diarias en cajeros.");
		maps.put("218", "No existe línea de referencia ");
		maps.put("219", "Línea de referencia no vigente ");
		maps.put("223", "Excedido Límite de crédito del contrato.");
		maps.put("224", "Excedido Límite diario de tarjeta.");
		maps.put("225", "Excedido Límite mensual de tarjeta.");
		maps.put("226", "Excedido Límite diario por restricción.");
		maps.put("227", "Excedido Límite mensual por restricción.");
		maps.put("229", "Carga Máxima excedida.");
		maps.put("230", "Consumo máximo excedido.");
		maps.put("231", "No existe tipo de línea.");
		maps.put("232", "Excedido Límite de Crédito global de tarjeta.");
		maps.put("233", "Excedido Límite de línea.");
		maps.put("234", "El tipo de factura debe ser pago.");
		maps.put("909", "Mal funcionamiento del sistema");
		maps.put("998", "Solicitud duplicada");
		maps.put("118", "DENEGADA. TARJETA NO EXISTE");
		maps.put("125", "DENEGADA. TARJETA NO EFECTIVA ");
		maps.put("185", "IMPORTE SUPERA LIMITE ");
		maps.put("117", "DENEGADA. PIN INCORRECTO");
		maps.put("182", "FECHA CADUCIDAD ERRONEO");
		maps.put("197", "DENEGADA.INCORRECTO CVV2/CVC2 ");
		maps.put("932", "DENEGADA. VALIDACION ARQC");
		maps.put("930", "DENEGADA FALLBACK.");
		maps.put("153", "EXCEDE LIMITE LINEA");
		maps.put("107", "DENEGADA. REFERENCIA AL EMISOR");
		maps.put("129", "DENEG. SOSPECHA FALSIFICACION ");
		maps.put("190", "DENEGADA.CADUCIDAD NO INFORMADA");
		maps.put("911", "EMISOR DE TJT FUERA DE TIEMPO ");
		return maps;
	}

	public static HashMap<String, String> getListFLX() {
		HashMap<String, String> maps = new HashMap<>();
		maps.put("00", "Transacción Aprobada");
		maps.put("99", "Transacción Rechazada");
		return maps;
	}
	
	public static HashMap<String, String> getListPYT() {
		HashMap<String, String> maps = new HashMap<>();
		maps.put("00", "Transacción Aprobada");
		maps.put("59", "Sospecha de fraude (PYT)");
		maps.put("  ", "Time Out");
		return maps;
	}

	
	public static HashMap<String, String> getListGNG() {
		HashMap<String, String> maps = new HashMap<>();
		maps.put("00", "Transacción Aprobada");
		maps.put("58", "Sospecha de fraude (GNG)");
		maps.put("  ", "Link Out");
		return maps;
	}
	
	public static HashMap<String, String> getListSTP() {
		HashMap<String, String> maps = new HashMap<>();
		maps.put("00", "Transacción Aprobada");
		maps.put("58", "Sospecha de fraude (GNG)");
		maps.put("  ", "Link Out");
		return maps;
	}
	
	public static HashMap<String, String> getListEntryPos() {
		HashMap<String, String> maps = new HashMap<>();
		maps.put("   ", "");
		maps.put("000","Unknown- Unknown");
		maps.put("001","Unknown- Terminal can accept entry of PINs");
		maps.put("002","Unknown- Terminal cannot accept entry PINs");
		maps.put("008","Unknown- Terminal PIN pad down");
		maps.put("010","Manual- Unknown");
		maps.put("011","Manual- Terminal can accept entry of PINs");
		maps.put("012","Manual- Terminal cannot accept entry PINs");
		maps.put("018","Manual- Terminal PIN pad down");
		maps.put("050","Integrated circuit read- Unknown");
		maps.put("051","Integrated circuit read- Terminal can accept entry of PINs");
		maps.put("052","Integrated circuit read- Terminal cannot accept entry PINs");
		maps.put("058","Integrated circuit read- Terminal PIN pad down");
		maps.put("070","Contactless M/Chip- Unknown");
		maps.put("071","Contactless M/Chip- Terminal can accept entry of PINs");
		maps.put("072","Contactless M/Chip- Terminal cannot accept entry PINs");
		maps.put("078","Contactless M/Chip- Terminal PIN pad down");
		maps.put("800","FallBack- Unknown");
		maps.put("801","FallBack- Terminal can accept entry of PINs");
		maps.put("802","FallBack- Terminal cannot accept entry PINs");
		maps.put("808","FallBack- Terminal PIN pad down");
		maps.put("810","Electronic Commerce- Unknown");
		maps.put("811","Electronic Commerce- Terminal can accept entry of PINs");
		maps.put("812","Electronic Commerce- Terminal cannot accept entry PINs");
		maps.put("818","Electronic Commerce- Terminal PIN pad down");
		maps.put("900","Magnetic stripe read and exact content of track1 o track2 included- Unknown");
		maps.put("901","Magnetic stripe read and exact content of track1 o track2 included- Terminal can accept entry of PINs");
		maps.put("902","Magnetic stripe read and exact content of track1 o track2 included- Terminal cannot accept entry PINs");
		maps.put("908","Magnetic stripe read and exact content of track1 o track2 included- Terminal PIN pad down");
		maps.put("910","Contactless (Track2 o Track1 completo)- Unknown");
		maps.put("911","Contactless (Track2 o Track1 completo)- Terminal can accept entry of PINs");
		maps.put("912","Contactless (Track2 o Track1 completo)- Terminal cannot accept entry PINs");
		maps.put("918","Contactless (Track2 o Track1 completo)- Terminal PIN pad down");
		return maps;
	}
}

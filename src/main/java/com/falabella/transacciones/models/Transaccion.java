package com.falabella.transacciones.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Transaccion {
	private String numeroTarjetaTransaccion;
	private String secuenciaTarjetaTransaccion;
	private String fechaExpiracionTransaccion;
	private String codigoTransferenciaAdqTransaccion;
	private int valorOriginalTransaccion;
	private String monedaValorOriginalTransaccion;
	private String ultimoPasoTransaccion;
	private String codigoRespuestaAdqTransaccion;
	private int fechaInicioTransaccion;
	private int horaInicioTransaccion;
	private int millisInicioTransaccion;
	private int fechaFinalTransaccion;
	private int horaFinalTransaccion;
	private int millisFinalTransaccion;
	private String isTimeoutTransaccion;
	private String redAdqTransaccion;
	private String adqInstCodeTransaccion;
	private String aplicacionTransaccion;
	private String codTerminalAdqTransaccion;
	private String dscTerminalAdqTransaccion;
	private String numReferenciaTransaccion;
	private String secuenciaTransaccion;
	private int fechaContAdqTransaccion;
	private int fechaLocalAdqTransaccion;
	private int horaLocalAdqTransaccion;
	private int comisionDelAdqTransaccion;
	private String isConfirmadaTransaccion;
	private String isDuplicadaTransaccion;
	private int fechaMsgDupTransaccion;
	private int horaMsgDupTransaccion;
	private int parteCashTransaccion;
	private String posEntryModeTransaccion;
	private String posConditCodeTransaccion;
	private String redDestinoTransaccion;
	private String codTrnEmisorTransaccion;
	private String codTerminalEmisorTransaccion;
	private String codRespuestaEmisorTransaccion;
	private int fechaContEmiTransaccion;
	private String numAutorizacionTransaccion;
	private String estadoTransaccion;
	private String isForzadaTransaccion;
	private int fechaReingresoTransaccion;
	private int horaReingresoTransaccion;
	private String codRspReingresoTransaccion;
	private String monedaCtaDebitoTransaccion;
	private int tasaReprDebitoTransaccion;
	private String tipoCtaDebitoTransaccion;
	private String numeroCtaDebitoTransaccion;
	private String monedaCtaCreditoTransaccion;
	private int tasaReprCreditoTransaccion;
	private String tipoCtaCreditoTransaccion;
	private String numeroCtaCreditoTransaccion;
	private String motivoTransaccion;
	private String codRspReversaTransaccion;
	private int valorReemplazoTransaccion;
	private String indConcAdqTransaccion;
	private int fecConcAdqTransaccion;
	private String codRspConcAdqTransaccion;
	private String indConpAdqTransaccion;
	private int fecConpAdqTransaccion;
	private String codRspConpAdqTransaccion;
	private String indComcEmiTransaccion;
	private int fecComcEmiTransaccion;
	private String codRspComcEmiTransaccion;
	private String indCompEmiTransaccion;
	private int fecCompEmiTransaccion;
	private String codRspCompEmiTransaccion;	
	private String indContExtractTransaccion;
	private int fechaContExtractTransaccion;
	private String fillerAdquirienTransaccion;
	private String fillerEmisorTransaccion;
	private String numeroTarjetaMaestroCuenta;
	private String secuenciaMaestroCuenta;
	private String claseMaestroCuenta;
	private String tipoDocumentoIdentidadMaestroCuenta;
	private String documentoIdentidadMaestroCuenta;
	private String nombreClienteMaestroCuenta;
	private String nombreTarjetaMaestroCuenta;
	private String estadoMaestroCuenta;
	private String empresaMaestroCuenta;
	private String indiceLlaveMaestroCuenta;
	private String offSetPVVMaestroCuenta;
	private int fechaExpiracionMaestroCuenta;
	private int fechaActivacionMaestroCuenta;
	private int horaActivacionMaestroCuenta;
	private String oficinaAperturaMaestroCuenta;
	private String codigoTarifaMaestroCuenta;
	private String codigoPerfilMaestroCuenta;
	private String metodoDebitoMaestroCuenta;
	private int numeroTransaccionMaestroCuenta;
	private int numeroErrorPinMaestroCuenta;
	private int fechaUltTrxMaestroCuenta;
	private int horaUltTrxMaestroCuenta;
	private String causaBloqueoDesbloqueoMaestroCuenta;
	private String idTarjetaPpalMaestroCuenta;
	private String indicadoresMaestroCuenta;
	private String mensajeTransaccionAzMgs;
	private String entryModePOS;
	private List<TrxDetails> trxDetails;
}
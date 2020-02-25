
# Microservicio transacciones REST
Para levantar el microservicio, es necesario entrar por ssh al servidor AIX mediante este comando.
```bash
ssh ${usuario}@${host}
```

## Levantar el microservicio
Para levantar el microservicio springboot, utilizar el siguiente comando sh dentro del servidor AIX.

```bash
java -Xms256m -jar /Workspace/POC/ms-transacciones-rest.jar
```
### Curl con el formato de consumo
```bash
curl -X GET \
  http://localhost:8082/transaccion \
  -H 'Postman-Token: 96bf7973-2186-42d8-99e8-1bd698f27410' \
  -H 'bin: 522375' \
  -H 'cache-control: no-cache' \
  -H 'fechaDesde: 20190101' \
  -H 'fechaHasta: 20191118' \
  -H 'horaDesde: 000000' \
  -H 'horaHasta: 200000' \
  -H 'rut: DUOJ780515HSLXL' \
  -H 'ultimosDigitos: 6271'
```
### Datos de prueba

* Dato 1
	* Documento de Identificacion: 009874818-0
	* Numero de Tarjeta cifrado: 603142084216000000004
	* Bin: 603142
	* Ultimos 4 digitos: 0842
* Dato 2
 	* Documento de Identificacion: 004804039-K
	* Numero de Tarjeta cifrado: 603142721716000000006
	* Bin: 603142
	* Ultimos 4 digitos: 7217
* Dato 3
	* Documento de Identificacion: 017334188-1  
	* Numero de Tarjeta cifrado: 421413444916000000001
	* Bin: 421413
	* Ultimos 4 digitos: 4449
* Dato 4
	* Documento de Identificacion: OETC890409MMCLL
	* Numero de Tarjeta cifrado: 854899282716000000018
	* Bin: 854899
	* Ultimos 4 digitos: 2827

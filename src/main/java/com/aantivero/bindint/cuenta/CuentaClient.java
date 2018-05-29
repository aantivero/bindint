package com.aantivero.bindint.cuenta;

import com.aantivero.bindint.cuenta.model.Cuenta;
import com.aantivero.bindint.cuenta.model.Movimiento;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface CuentaClient {

    @RequestLine("GET /banks/{bank_id}/accounts")
    @Headers("Authorization: {token}")
    List<Cuenta> consultaDeVistas(@Param("bank_id") String bank_id, @Param("token") String token);

    @RequestLine("GET /banks/{bank_id}/accounts/{view_id}")
    @Headers("Authorization: {token}")
    List<Cuenta> consultaDeCuentas(@Param("bank_id") String bank_id, @Param("view_id") String view_id, @Param("token") String token);

    @RequestLine("GET /banks/{bank_id}/accounts/{account_id}/{view_id}")
    @Headers("Authorization: {token}")
    Cuenta consultaDeCuenta(@Param("bank_id") String bank_id, @Param("account_id")String account_id,
                              @Param("view_id") String view_id, @Param("token") String token);

    @RequestLine("GET /banks/{bank_id}/accounts/{account_id}/{view_id}/transactions")
    @Headers("Authorization: {token}")
    List<Movimiento> consultaDeMovimientos(@Param("bank_id") String bank_id, @Param("account_id") String account_id,
                                           @Param("view_id") String view_id, @Param("token") String token);
}

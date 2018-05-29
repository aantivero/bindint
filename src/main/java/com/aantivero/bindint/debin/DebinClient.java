package com.aantivero.bindint.debin;

import com.aantivero.bindint.debin.model.Adhesion;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface DebinClient {

    @RequestLine("PUT /banks/{bank_id}/accounts/{account_id}/{view_id}/transaction-request-types/DEBIN")
    @Headers({"Authorization: {token}", "Content-Type: application/json"})
    Adhesion altaBajaDeCuentaVendedor(@Param("bank_id") String bank_id, @Param("account_id") String account_id,
                                      @Param("view_id") String view_id, @Param("token") String token,
                                      @Param("adhered") boolean adhesion);
}

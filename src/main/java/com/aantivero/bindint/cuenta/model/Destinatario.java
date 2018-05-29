package com.aantivero.bindint.cuenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Destinatario {

    private String id;
    private String name;
    private String id_type;
    private BancoDelDestinatario bank_routing;
    private CuentaDelDestinatario account_routing;
}

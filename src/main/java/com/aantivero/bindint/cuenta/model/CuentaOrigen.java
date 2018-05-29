package com.aantivero.bindint.cuenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CuentaOrigen {
    private String id;
    private String kind;
    private BancoDelDestinatario bank_rounting;
    private CuentaDelDestinatario account_rounting;
}

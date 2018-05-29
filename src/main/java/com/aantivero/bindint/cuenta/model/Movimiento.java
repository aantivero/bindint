package com.aantivero.bindint.cuenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movimiento {
    private String id;
    private Destinatario counterParty;
    private Detalle details;
    private InformacionAdicional metadata;
    private CuentaOrigen this_account;
}
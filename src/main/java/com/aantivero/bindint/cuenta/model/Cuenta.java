package com.aantivero.bindint.cuenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {

    private String id;
    private String label;
    private String number;
    private String type;
    private String status;
    private List<IntegranteDeCuenta> owners;
    private Saldo balance;
    private String bank_id;
    private List<Views> views_available;
    private InformacionDeLaCuenta account_routing;
}

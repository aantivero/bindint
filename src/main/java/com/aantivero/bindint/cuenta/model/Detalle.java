package com.aantivero.bindint.cuenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Detalle {

    private String type;
    private String decription;
    private String posted;
    private String completed;
    private Importe value;
    private String motive;
    private String reference_number;
    private Saldo new_balance;
}

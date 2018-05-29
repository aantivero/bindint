package com.aantivero.bindint.cuenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IntegranteDeCuenta {
    private String id;
    private String id_type;
    private String is_physical_person;
    private String display_name;
}

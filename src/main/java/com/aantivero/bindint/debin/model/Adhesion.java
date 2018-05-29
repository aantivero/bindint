package com.aantivero.bindint.debin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Adhesion {
    private boolean adhered;
    private String account_id;
}

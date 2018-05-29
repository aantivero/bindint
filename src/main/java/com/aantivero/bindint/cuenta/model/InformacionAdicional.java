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
public class InformacionAdicional {

    private String narrative;
    private String comments;
    private List<String> tags;
    private String images;
    private String where;
}

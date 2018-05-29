package com.aantivero.bindint.cuenta.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Views {

    private String id;

    private String shortName;

    @SerializedName("public")
    private boolean a;
}

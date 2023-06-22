package com.goodfood.goodfood.kakaomap.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class DocumentDTO {

    @JsonProperty("address_name")
    private String addressName;

    @JsonProperty("x")
    private double x;

    @JsonProperty("y")
    private double y;

}

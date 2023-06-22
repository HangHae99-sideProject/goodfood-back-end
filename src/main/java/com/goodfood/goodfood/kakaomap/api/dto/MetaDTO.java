package com.goodfood.goodfood.kakaomap.api.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
public class MetaDTO {

    //Json 응답을 받을때 맵핑 시켜준다.
    @JsonProperty("total_count")
    private Integer totalCount;

}

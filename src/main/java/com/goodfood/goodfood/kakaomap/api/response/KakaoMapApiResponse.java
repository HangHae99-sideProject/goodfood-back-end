package com.goodfood.goodfood.kakaomap.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goodfood.goodfood.kakaomap.api.dto.DocumentDTO;
import com.goodfood.goodfood.kakaomap.api.dto.MetaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
public class KakaoMapApiResponse {

    @JsonProperty("meta")
    private MetaDTO metaDTO;

    @JsonProperty("documents")
    private List<DocumentDTO> documentList;

}

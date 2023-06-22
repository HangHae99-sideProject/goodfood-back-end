package com.goodfood.goodfood.kakaomap.service;

import com.goodfood.goodfood.kakaomap.api.response.KakaoMapApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@Service
public class KaKaoAddressSearchService {

    private final RestTemplate restTemplate;

    private static final String KAKAO_LOCAL_SEARCH_ADDRESS_URL = "https://dapi.kakao.com/v2/local/search/address.json";

    @Value("${kakao.rest.api.key}")
    private String kakaoApi;

    public KakaoMapApiResponse requestAddressSearch(String address) {

        if (ObjectUtils.isEmpty(address)) return null;
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "KakaoAK " + kakaoApi);
        HttpEntity http = new HttpEntity<>(headers);

        ResponseEntity<KakaoMapApiResponse> sendKaKaoAPI = restTemplate.exchange(
                buildUriByAddressSearch(address),
                HttpMethod.GET,
                http,
                KakaoMapApiResponse.class
        );
        return sendKaKaoAPI.getBody();
    }

    private URI buildUriByAddressSearch(String address) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(KAKAO_LOCAL_SEARCH_ADDRESS_URL);
        uriComponentsBuilder.queryParam("query", address);

        //encode() UTF-8 인코딩
        URI uri = uriComponentsBuilder.build().encode().toUri();
        log.info("[KAKAO_LOCAL_SEARCH_ADDRESS_URL] address : {}, uri : {}", address, uri);
        return uri;
    }

}

package com.goodfood.goodfood.global.repository;

import com.goodfood.goodfood.global.entity.Restaurant;
import com.goodfood.goodfood.global.service.RestaurantService;
import com.goodfood.goodfood.kakaomap.api.response.KakaoMapApiResponse;
import com.goodfood.goodfood.kakaomap.service.KaKaoAddressSearchService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class RestaurantRepositoryTest {

    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private KaKaoAddressSearchService searchService;

    @Autowired
    private RestaurantService restaurantService;

    @Test
    @DisplayName("데이터 하나 갖고와서 좌표 변환후 카카오맵에 있는 좌표랑 동일한지 확인.")
    void test() {
        int num = 11;

        //좌표 변환후 데이터 가져오기
        Restaurant restaurant = restaurantService.updateCoordinateOne(num);
        log.info(restaurant.toString());

        //주소 넘겨주고
        KakaoMapApiResponse response = searchService.requestAddressSearch(restaurant.getFull_address_of_location());
        log.info(response.toString());
        String x = "" + response.getDocumentList().get(0).getX();
        String y = "" + response.getDocumentList().get(0).getY();

        //왜 안맞아?

        log.info(x);
        log.info(restaurant.getCoordinate_information_x());
        log.info(y);
        log.info(restaurant.getCoordinate_information_y());
        assertEquals(x, restaurant.getCoordinate_information_x());
        assertEquals(y, restaurant.getCoordinate_information_y());

    }

}

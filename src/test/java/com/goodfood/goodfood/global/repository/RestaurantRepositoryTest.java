package com.goodfood.goodfood.global.repository;

import com.goodfood.goodfood.global.entity.Restaurant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
class RestaurantRepositoryTest {

    @Autowired
    private RestaurantRepository repository;

    @Test
    void test() {

        Restaurant restaurant = repository.findById(1L).get();

        log.info(restaurant.toString());
        assertNotNull(restaurant);
    }

}

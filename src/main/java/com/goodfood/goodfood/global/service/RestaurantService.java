package com.goodfood.goodfood.global.service;

import com.goodfood.goodfood.global.entity.Restaurant;
import com.goodfood.goodfood.global.repository.RestaurantRepository;
import com.goodfood.goodfood.global.util.ChangeCoordinate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository repository;
    private final ChangeCoordinate changeCoordinate;

    @Transactional
    public Restaurant updateCoordinateOne(Integer num){
        Restaurant restaurant = repository.findById(num)
                .orElseThrow(()->
                        new NullPointerException("현제 데이터베이스에 있는 데이터가 존재하지 않습니다.")
                );
        double x = Double.parseDouble(restaurant.getCoordinate_information_x());
        double y = Double.parseDouble(restaurant.getCoordinate_information_y());
        String[] xy = changeCoordinate.change(x,y);
        System.out.println(Arrays.toString(xy));
        restaurant.setCoordinate_information_x(xy[0]);
        restaurant.setCoordinate_information_y(xy[1]);
        return restaurant;
    }


}

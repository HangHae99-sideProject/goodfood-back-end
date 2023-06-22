package com.goodfood.goodfood.global.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Entity
public class Restaurant {

    @Id
    Long num;

    private String open_service_name;
    private String open_service_id;
    private String open_local_government_code;
    private String management_number;
    private String date_of_license;
    private String date_of_license_cancellation;
    private String business_status_classification_code;
    private String business_status_name;
    private String detailed_business_status_code;
    private String detailed_business_status_name;
    private String date_of_closure;
    private String closed_start_date;
    private String closed_date;
    private String reopening_date;
    private String location_phone;
    private String material_area;
    private String address_zip_code;
    private String full_address_of_location;
    private String road_namefull_address;
    private String road_name_zip_code;
    private String business_name;
    private String last_modified_time;
    private String classification_of_data_renewal;
    private String data_update_date;
    private String clear_business_type;
    private String coordinate_information_x;
    private String coordinate_information_y;
    private String name_of_hygiene_business;
    private String number_of_male_employees;
    private String number_of_female_employees;
    private String classification_around_the_business_place;
    private String classification_name;
    private String classification_of_water_supply_facilities;
    private String total_number_of_employees;
    private String number_of_head_office_employees;
    private String no_of_factory_office_workers;
    private String number_of_factory_sales_employees;
    private String number_of_factory_production_workers;
    private String classification_of_building_ownership;
    private String guarantee_amount;
    private String monthly_rent;
    private String whether_it_is_a_multi_use_business;
    private String total_facility_scale;
    private String traditional_business_designation_number;
    private String traditional_business_staple_food;
    private String home_page;

}

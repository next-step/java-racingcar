package com.java.jaeheon.step2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.java.jaeheon.step2.model.CarManagement;

import static org.assertj.core.api.Assertions.assertThat;

public class CarManagementTest {
    CarManagement cars;

    @BeforeEach
    void setup(){
        this.cars = new CarManagement();
    }

    @Test
    void register(){
        assertThat(cars.register().numberOfRegisteredCars()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 9})
    void registerByNumber(int numberOfCars) {
        this.cars = new CarManagement();
        assertThat(cars.registerByNumber(numberOfCars).numberOfRegisteredCars()).isEqualTo(numberOfCars);
    }

}

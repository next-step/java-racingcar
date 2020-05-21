package com.kimdahyeee.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@DisplayName("자동차 경주 단위 테스트")
class CarTest {

    @ParameterizedTest
    @DisplayName("자동차는 랜덤 값이 4 미만이면 전진하지 않는다.")
    @ValueSource(ints = {1, 3})
    void stop(int randomValue) {
        Car car = spy(new Car("name"));
        when(car.getRandomNumber()).thenReturn(randomValue);

        car.move();

        assertEquals(0, car.getPosition());
    }

    @ParameterizedTest
    @DisplayName("자동차는 랜덤 값이 4 이상이면 전진한다.")
    @ValueSource(ints = {4, 5, 9})
    void move(int randomValue) {
        Car car = spy(new Car("name"));
        when(car.getRandomNumber()).thenReturn(randomValue);

        car.move();

        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("자동차 최대값 비교")
    void compareTo() {
        Car car = spy(new Car("name"));
        when(car.getRandomNumber()).thenReturn(9);
        car.move();

        Car comparedCar = new Car("comparedCar");

        List<Car> racingCars = new ArrayList<>();
        racingCars.add(car);
        racingCars.add(comparedCar);

        assertEquals(1,
                racingCars.stream()
                        .max(Car::compareTo)
                        .get()
                        .getPosition());
    }

}
package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarsTest {

    private static final int CAR_FORCE_MOVE_NUMBER = 9;

    @ParameterizedTest(name = "[{index}] Cars 객체에 (,) 구분자를 기준으로 이름만큼 자동차를 생성한다.")
    @CsvSource(value = {"rick,jack,ethan:3", "ethan:1", "jack,ethan:2"}, delimiter = ':')
    void createCarsSuccessTest(String valueSource, int expectedCarSize) {
        Cars cars = new Cars(new CarNameChunk(valueSource));
        assertThat(cars.carSize()).isEqualTo(expectedCarSize);
    }

    @ParameterizedTest(name = "[{index}] Cars 1급 객체 0 이하의 숫자 생성자에 유입된 경우 익셉션을 발생 시킨다.")
    @NullAndEmptySource
    void createCarsFailTest(String valueSource) {
        assertThatThrownBy(() -> {
            new Cars(new CarNameChunk(valueSource));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름이 임력되지 않았습니다.");
    }

    @Test
    @DisplayName("Cars 객체에서 가장 멀리간 자동차를 찾아낸다.")
    void getFurthestTraveledCarTest() {
        Car patCar = new Car("pat");

        // move 2 steps forward
        patCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);
        patCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);

        Car rickCar = new Car("rick");

        Car ethanCar = new Car("ethan");

        Cars cars = new Cars(Arrays.asList(patCar, rickCar, ethanCar));
        assertThat(cars.findFirstFurthestTraveledCar().getCarName()).isEqualTo("pat");
    }

    @Test
    @DisplayName("Cars 객체에서 가장 멀리간 자동차가 2개 이상일 경우 첫번째 자동차가 선택된다.")
    void findFirstFurthestTraveledCarTest() {
        Car patCar = new Car("pat");

        Car rickCar = new Car("rick");

        rickCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);
        rickCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);

        Car ethanCar = new Car("ethan");

        ethanCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);
        ethanCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);

        Cars cars = new Cars(Arrays.asList(patCar, rickCar, ethanCar));
        assertThat(cars.findFirstFurthestTraveledCar().getCarName()).isEqualTo("rick");
    }

    @Test
    @DisplayName("Cars 객체에서 가장 멀리간 자동차가 2대를 , 기준으로 합하여 결과를 반환한다.")
    void joinWinnerNamesTest() {
        Car patCar = new Car("pat");

        Car rickCar = new Car("rick");

        rickCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);
        rickCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);

        Car ethanCar = new Car("ethan");

        ethanCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);
        ethanCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);

        Cars cars = new Cars(Arrays.asList(patCar, rickCar, ethanCar));
        assertThat(cars.joinedWinnerNames()).isEqualTo("rick,ethan");
    }

    @Test
    @DisplayName("Cars 객체에서 가장 멀리간 자동차의 거리를 반환한다.")
    void getFurthestTraveledCarDistanceTest() {
        Car patCar = new Car("pat");

        // move 2 steps forward
        patCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);
        patCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);

        Car rickCar = new Car("rick");

        rickCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);
        rickCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);
        rickCar.moveForwardByNumber(CAR_FORCE_MOVE_NUMBER);

        Car ethanCar = new Car("ethan");

        Cars cars = new Cars(Arrays.asList(patCar, rickCar, ethanCar));
        Car f = cars.findFirstFurthestTraveledCar();
        assertThat(cars.getFurthestDistance()).isEqualTo(3);
    }
}
package com.nextstep.racingcargame.core;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

    private static final String APPROPRIATE_TEST_CAR_NAME = "test";

    private static final int SINGLE_OBJECT_SIZE = 1;

    private static final int TRIPLE_OBJECT_SIZE = 3;

    private static final String WINNER_JOIN_DELIMITER = ",";

    private static final String CAR_DISTANCE_DISPLAY_UNIT = "-";

    private static final String CAR_NAME_AND_DISTANCE_DELIMITER = " : ";

    @ParameterizedTest(name = "[{index}] Cars 객체에 (,) 구분자를 기준으로 이름만큼 자동차를 생성한다.")
    @CsvSource(value = {"rick,jack,ethan:3", "ethan:1", "jack,ethan:2"}, delimiter = ':')
    void createCarsSuccessTest(String valueSource, int expectedCarSize) {
        Cars cars = new Cars(new CarNameChunk(valueSource));
        assertThat(cars.carSize()).isEqualTo(expectedCarSize);
    }

    @Test
    @DisplayName("객체 사이즈가 1 이상일 경우 정상 Cars 객체를 반환한다.")
    public void isMoreThanOneCarTest() {
        Car patCar = new Car("pat");
        Car rickCar = new Car("rick");
        Car ethanCar = new Car("ethan");

        Cars cars = new Cars(asList(patCar, rickCar, ethanCar));
        assertThat(cars.carSize()).isEqualTo(TRIPLE_OBJECT_SIZE);
    }

    @DisplayName("주 생성자에 정상 자동차 객체 주입시 객채가 정상 생성된다.")
    @Test
    void createCarsSuccessTestWithRootCtor() {
        Cars cars = new Cars(List.of(new Car(APPROPRIATE_TEST_CAR_NAME)));
        assertThat(cars.carSize()).isEqualTo(SINGLE_OBJECT_SIZE);
    }

    @DisplayName("주 생성자에 빈 배열이 유입된 경우 예외를 발생한다.")
    @Test
    void createCarsSuccessWithRootCtor() {
        assertThatThrownBy(() -> {
            new Cars(new ArrayList<>());
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 보다 작은 수의 차량은 생성될 수 없습니다.");
    }

    @Test
    @DisplayName("Cars 객체에서 가장 멀리간 자동차의 거리(Distance) 객체를 반환한다.")
    void getFurthestTraveledCarTest() {
        Car patCar = new Car("pat", 3);
        Car rickCar = new Car("rick", 2);
        Car ethanCar = new Car("ethan", 1);

        Cars cars = new Cars(asList(patCar, rickCar, ethanCar));
        assertThat(cars.longestDistance()).isEqualTo(new Distance(3));
    }

    @Test
    @DisplayName("Cars 객체에서 가장 멀리간 자동차가 2대를 , 기준으로 합하여 결과를 반환한다.")
    void joinWinnerNamesTest() {
        Car patCar = new Car("pat");
        Car rickCar = new Car("rick", 2);
        Car ethanCar = new Car("ethan", 2);

        Cars cars = new Cars(asList(patCar, rickCar, ethanCar));
        assertThat(cars.joinedWinnerNames(WINNER_JOIN_DELIMITER)).isEqualTo("rick,ethan");
    }

    @Test
    @DisplayName("Cars 객체에서 가장 멀리간 자동차의 거리를 반환한다.")
    void getFurthestTraveledCarDistanceTest() {
        Car patCar = new Car("pat", 2);
        Car rickCar = new Car("rick", 3);
        Car ethanCar = new Car("ethan");

        Cars cars = new Cars(asList(patCar, rickCar, ethanCar));
        assertThat(cars.longestDistance()).isEqualTo(new Distance(3));
    }

    @Test
    @DisplayName("각 자동차별 현재 거리와 이름 배열을 콘솔 포멧이 맞게 리턴한다.")
    void getAllCarCurrentDistanceTest() {
        int moveTwoSteps = 2;
        int moveThreeSteps = 3;

        Car patCar = new Car("pat", moveTwoSteps);
        Car rickCar = new Car("rick", moveThreeSteps);

        String expectedPatCarFormat = patCar.getCarName()
                + CAR_NAME_AND_DISTANCE_DELIMITER
                + CAR_DISTANCE_DISPLAY_UNIT.repeat(moveTwoSteps);

        String expectedRickCarFormat = rickCar.getCarName()
                + CAR_NAME_AND_DISTANCE_DELIMITER
                + CAR_DISTANCE_DISPLAY_UNIT.repeat(moveThreeSteps);

        Cars cars = new Cars(asList(patCar, rickCar));
        List<String> carCurrentDistances = cars.getAllCarCurrentDistance(
                CAR_NAME_AND_DISTANCE_DELIMITER, CAR_DISTANCE_DISPLAY_UNIT);

        assertThat(carCurrentDistances)
                .contains(expectedPatCarFormat, expectedRickCarFormat);
    }
}
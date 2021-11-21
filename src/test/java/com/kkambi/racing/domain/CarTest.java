package com.kkambi.racing.domain;

import com.kkambi.racing.strategy.RandomMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    // FIXME: 테스트 수정 필요
    @DisplayName("자동차 전진 시도")
    @MethodSource("getRandomValueWhenTryToMove")
    @ParameterizedTest
    void tryToCarMove(int randomValue, Location expectedLocation) {
        // given
        Car car = new Car(0, "pobi");
        car.setMovingStrategy(new RandomMovingStrategy());

        // when
        car.move();

        // then
        assertThat(car.getLocation()).isEqualTo(expectedLocation);
    }

    static Stream<Arguments> getRandomValueWhenTryToMove() {
        return Stream.of(
                Arguments.of(1, new Location(0)),
                Arguments.of(4, new Location(1)),
                Arguments.of(9, new Location(1))
        );
    }

    @DisplayName("이름과 위치를 가진 자동차가 생성된다")
    @Test
    void create_car_with_name() {
        // given
        int locationValue = 1;
        String nameValue = "crong";

        // when
        Car car = new Car(locationValue, nameValue);

        // then
        assertThat(car.getLocation().getValue()).isEqualTo(locationValue);
        assertThat(car.getName().getValue()).isEqualTo(nameValue);
    }


    @DisplayName("자동차끼리 위치로 대소 비교할 수 있다")
    @Test
    void compareByLocation() {
        // given
        Car car1 = new Car(0, "a");
        Car car2 = new Car(1, "b");

        // when
        // then
        assertThat(car1).isLessThan(car2);
        assertThat(car2).isGreaterThan(car1);
    }

    @DisplayName("자동차끼리 위치로 동등 비교할 수 있다")
    @Test
    void equalsByLocation() {
        // given
        Car car1 = new Car(1, "a");
        Car car2 = new Car(1, "b");

        // when
        // then
        assertThat(car1).isEqualTo(car2);
    }
}
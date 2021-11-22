package com.kkambi.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @DisplayName("자동차 집합은 불변이다")
    @Test
    void immutable_cars() {
        // given
        String[] names = {"crong", "honux"};
        Cars cars = new Cars(Arrays.asList(
                new Car(0, names[0]),
                new Car(0, names[1])
        ));

        // when
        List<Car> carList = cars.getCars();

        // then
        assertThatThrownBy(() -> carList.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("자동차 경주의 우승자를 결정한다")
    @MethodSource("getCars")
    @ParameterizedTest
    void chooseWinners(List<Car> allCars, List<Car> winningCars) {
        // given
        Cars cars = new Cars(allCars);
        Winners expectedWinners = new Winners(winningCars);

        // when
        Winners winners = cars.chooseWinners();

        // then
        assertThat(winners).isEqualToComparingFieldByFieldRecursively(expectedWinners);
    }

    static Stream<Arguments> getCars() {
        Car car1 = new Car(0, "a");
        Car car2 = new Car(1, "b");
        Car car3 = new Car(2, "c");
        Car car4 = new Car(2, "d");

        return Stream.of(
                Arguments.of(Arrays.asList(car1, car2, car3), Collections.singletonList(car3)),
                Arguments.of(Arrays.asList(car1, car2, car3, car4), Arrays.asList(car3, car4)),
                Arguments.of(Arrays.asList(car1, car2), Collections.singletonList(car2))
        );
    }
}
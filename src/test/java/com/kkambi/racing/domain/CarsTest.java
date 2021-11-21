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
}
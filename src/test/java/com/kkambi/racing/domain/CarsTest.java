package com.kkambi.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @DisplayName("이름에 맞게 자동차가 생성된다")
    @Test
    void create_cars_with_names() {
        // given
        String[] names = {"crong", "honux", "pobi"};

        // when
        Cars cars = new Cars(names);

        // then
        List<Car> carList = cars.getCars();
        assertThat(carList).hasSize(names.length);
        assertThat(carList).allSatisfy(
                car -> assertThat(names).contains(car.getName().getValue())
        );
    }

    @DisplayName("자동차 집합은 불변이다")
    @Test
    void immutable_cars() {
        // given
        String[] names = {"crong", "honux", "pobi"};
        Cars cars = new Cars(names);

        // when
        List<Car> carList = cars.getCars();

        // then
        assertThatThrownBy(() -> carList.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
package com.nextstep.racingcar.domain.car;

import com.nextstep.racingcar.domain.round.ForceMoveCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTests {
    @DisplayName("Car 객체 리스트를 입력 받아서 일급 콜렉션 객체 생성")
    @Test
    void createCars() {
        List<Car> carCollection = Arrays.asList(new ForceMoveCar(), new ForceMoveCar());
        Cars cars = Cars.create(carCollection);
        assertThat(cars).isNotNull();
    }

    @DisplayName("컬렉션 사이드 이펙트 없음")
    @Test
    void cantModifyCarCollection() {
        List<Car> carCollection = new ArrayList<>();
        carCollection.add(new ForceMoveCar());

        Cars cars = Cars.create(carCollection);
        carCollection.add(new ForceMoveCar());

        assertThat(cars.size()).isNotEqualTo(2);
    }
}

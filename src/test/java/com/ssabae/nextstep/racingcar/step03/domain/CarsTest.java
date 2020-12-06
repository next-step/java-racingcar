package com.ssabae.nextstep.racingcar.step03.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-07
 */
class CarsTest {

    @Test
    @DisplayName("Cars 내부 Method Test")
    void carsTest() {
        Random random = new MockRandom();
        Cars cars = new Cars(random);

        cars.initCars(1);
        cars.moving();

        List<Car> carList = cars.getCarList();
        Car car = carList.get(0);

        assertThat(carList.size()).isEqualTo(1);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    // 무조건 전진만 하는 Random Mocking
    private static class MockRandom extends Random {

        @Override
        public int nextInt(int bound) {
            return 9;
        }
    }
}

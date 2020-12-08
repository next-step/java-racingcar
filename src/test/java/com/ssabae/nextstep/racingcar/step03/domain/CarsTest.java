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
@DisplayName("Car 일급컬렉션 Test Class")
class CarsTest {

    @Test
    @DisplayName("Cars 내부 Method Test")
    void carsTest() {
        Random random = new MockRandom();
        Cars cars = new Cars(random, "a");
        cars.moving();

        List<Car> carList = cars.getCarList();
        Car car = carList.get(0);

        assertThat(carList.size()).isEqualTo(1);
        assertThat(car.getMoveCount()).isEqualTo(1);
        assertThat(car.getName()).isEqualTo("a");
    }


    @Test
    @DisplayName("Cars 다중 우승자 테스트 Test")
    void shouldAllPlayersWinnerTest() {
        Random random = new MockRandom();
        Cars cars = new Cars(random, "a, b, c");

        cars.moving();

        assertThat(cars.getWinnerNames()).isEqualTo("a, b, c");
    }

    @Test
    @DisplayName("Cars 단일 우승자 테스트 Test")
    void shouldOnePlayerWinnerTest() {
        Random random = new MockRandom();
        Cars cars = new Cars(random, "a, b, c");

        cars.moving();
        Car car = cars.getCarList().get(0);
        car.move(MoveState.GO);

        assertThat(cars.getWinnerNames()).isEqualTo("a");
    }

    // 무조건 전진만 하는 Random Mocking
    private static class MockRandom extends Random {

        @Override
        public int nextInt(int bound) {
            return 9;
        }
    }
}

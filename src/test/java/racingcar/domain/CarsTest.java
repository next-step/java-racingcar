package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.factory.CarFactory;
import racingcar.strategy.RandomMoveStrategyTest;

class CarsTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        String carsName = "a,b,c";
        int tryCount = 5;
        racingGame = new RacingGame(new Cars(new CarFactory().generate(new CarName(carsName).carNameList())), tryCount);
        for (int i = 0; i < tryCount; i++) {
            if (i % 2 == 0) {
                racingGame.start(new RandomMoveStrategyTest(6));
            }
            racingGame.start(new RandomMoveStrategyTest(2));
        }
    }

    @Test
    @DisplayName("Cars 에 car 객체 추가되는 지 확인")
    void Cars_Car객체추가확인() {
        Cars cars = racingGame.cars();
        assertThat(cars.carList().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("carList 가 cars 를 반환하는 지 확인")
    void Cars_carList반환확인() {
        Cars cars = racingGame.cars();
        assertThat(cars.carList().isEmpty()).isFalse();
    }

    @Test
    @DisplayName("maxPosition 값을 가진 자동차 명을 반환하는 지 확인")
    void Cars_최대위치자동차명확인() {
        Cars cars = racingGame.cars();
        assertThat(cars.maxPositionCars()).contains("c");
    }
}
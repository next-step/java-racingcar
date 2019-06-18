package carRacing.model;

import carRacing.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {


    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ferrari"));
        cars.add(new Car("bmw"));
        cars.add(new Car("audi"));
        MockGamePoint mockGamePoint = new MockGamePoint(5); // 항상 전진
        racingGame = new RacingGame(new RacingCarGroup(cars), mockGamePoint);
    }

    @Test
    @DisplayName("자동차 경주 자동차 이동")
    void race() {
        racingGame.race();
        RacingCarGroup race = racingGame.race();
        List<Car> racingCars = race.getRacingCars();
        for (Car racingCar : racingCars) {
            assertThat(racingCar.getPosition()).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("우승자 판별")
    void gameResult() {
        racingGame.race();
        RacingCarGroup winners = racingGame.gameResult();

        Car ferrari = new Car("ferrari");
        Car bmw = new Car("bmw");
        Car audi = new Car("audi");
        assertThat(winners.getRacingCars()).containsExactly(ferrari, bmw, audi);



    }
}
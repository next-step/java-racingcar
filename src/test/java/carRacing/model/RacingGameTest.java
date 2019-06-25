package carRacing.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private List<Car> cars;
    static final int ALWAYS_GO = 4;
    static final int ALWAYS_STOP = 3;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(
                new Car("ferrari"),
                new Car("bmw"),
                new Car("audi"));
    }

    @Test
    @DisplayName("빈 자동차 리스트로 생성시 예외처리")
    void RacingGameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new RacingGame(new RacingCars(new ArrayList<>()), () -> 3);
        });
    }

    @Test
    @DisplayName("자동차 경주 자동차 이동")
    void race() {
        RacingGame racingGame = new RacingGame(new RacingCars(cars), () -> ALWAYS_GO);

        racingGame.race();
        RacingCars race = racingGame.race();
        List<Car> racingCars = race.getRacingCars();
        for (Car racingCar : racingCars) {
            assertThat(racingCar.getPosition()).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("자동차 경주 자동차 이동할 수 없음")
    void cannotMove() {
        RacingGame racingGame = new RacingGame(new RacingCars(cars), () -> ALWAYS_STOP);

        racingGame.race();
        RacingCars race = racingGame.race();
        List<Car> racingCars = race.getRacingCars();
        for (Car racingCar : racingCars) {
            assertThat(racingCar.getPosition()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("우승자 판별")
    void gameResult() {
        RacingGame racingGame = new RacingGame(new RacingCars(cars), () -> ALWAYS_GO);

        racingGame.race();
        RacingCars winners = racingGame.gameResult();

        Car ferrari = new Car("ferrari");
        Car bmw = new Car("bmw");
        Car audi = new Car("audi");
        assertThat(winners.getRacingCars()).containsExactly(ferrari, bmw, audi);
    }
}
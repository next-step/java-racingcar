package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private static final int TIME = 3;
    private static final String INPUT = "pobi,crong,honux";
    private static final String TEST_NAME = "car";
    private RacingGame racingGame;
    private Car car;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(TIME, INPUT);
        car = new Car(TEST_NAME);
    }

    @Test
    void domainRacingGameCreateCarObjectTest() {
        assertThat(racingGame.initiateCar(INPUT)).hasSize(3);
    }

    @Test
    void domainCarInitiatePositionTest() {
        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @Test
    void domainCarNameTest() {
        assertThat(car.getName()).isEqualTo(TEST_NAME);
    }

    @Test
    void domainCarUpdatePositionTest() {
        int currentPosition = car.currentPosition();
        car.updatePosition(currentPosition);
        assertThat(car.currentPosition()).isGreaterThanOrEqualTo(car.currentPosition());
    }

    @Test
    void domainAllCarUpdatePositionTest() {
        List<Car> cars = racingGame.move();
        assertThat(cars).hasSize(3);
        for (Car car : cars) {
            int currentPosition = car.currentPosition();
            car.updatePosition(currentPosition);
            assertThat(car.currentPosition()).isGreaterThanOrEqualTo(currentPosition);
        }
    }

    @Test
    void racingGameWinnerTest() {
        assertThat(car.isWinner()).isFalse();
        car.updateWinner(0);
        assertThat(car.isWinner()).isTrue();
    }
}
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
    private RacingGame racingGame;
    private Car car;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(TIME, INPUT);
        car = new Car("tom");
    }

    @Test
    void domainRacingGameCreateCarObjectTest() {
        assertThat(racingGame.initiateCar(INPUT)).hasSize(3);
    }

    @Test
    void domainCarUpdatePositionTest() {
        int currentPosition = car.getPosition();
        car.updatePosition(currentPosition);
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(car.getPosition());
    }

    @Test
    void domainAllCarUpdatePositionTest() {
        List<Car> cars = racingGame.move();
        assertThat(cars).hasSize(3);
        for (Car car : cars) {
            int currentPosition = car.getPosition();
            car.updatePosition(currentPosition);
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(currentPosition);
        }
    }
}
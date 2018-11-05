package racinggame.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingGame racingGame;
    private static final int RACE_TIME = 5;

    @Before
    public void setUp() {
        String[] inputCars = {"owner","chris","mary"};

        racingGame = new RacingGame(inputCars, RACE_TIME);
    }

    @Test
    public void 경기_완료() {
        List<Car> cars = null;
        while(!racingGame.isRaceEnd()) {
            cars = racingGame.raceOneTime();

        }

        for (Car car : cars) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
            assertThat(car.getPosition()).isLessThanOrEqualTo(5);
        }
    }

    @Test
    public void 레이스_경기_1회_시도() {
        List<Car> cars = racingGame.raceOneTime();

        cars.forEach(car -> assertThat(car.getPosition()).isLessThanOrEqualTo(1));
    }

}
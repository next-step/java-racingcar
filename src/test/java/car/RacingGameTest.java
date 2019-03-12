package car;

import car.entity.Car;
import car.entity.RacingGame;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    static final int INITIAL_CAR_COUNT = 3;
    static final int NOT_MOVING_RANDOM_NUM = 3;
    static final int MOVING_RANDOM_VALUE = 4;

    @Test
    public void initializeGame() {
        RacingGame racingGame = new RacingGame(INITIAL_CAR_COUNT);
        assertThat(racingGame.racingCars.size()).isEqualTo(INITIAL_CAR_COUNT);
    }

    @Test
    public void carStatusStop() {
        Car testCar = Car.getCarInstance();
        testCar.move(NOT_MOVING_RANDOM_NUM);

        assertThat(testCar.getMovingCount()).isEqualTo(0);
    }

    @Test
    public void carStatusStart() {
        Car testCar = Car.getCarInstance();
        testCar.move(MOVING_RANDOM_VALUE);

        assertThat(testCar.getMovingCount()).isEqualTo(1);
    }

}
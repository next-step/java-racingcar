package car;

import car.domain.Car;
import car.domain.RacingGame;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    static final int NOT_MOVING_RANDOM_NUM = 3;
    static final int MOVING_RANDOM_VALUE = 4;

    @Test
    public void 게임_초기화() {
        String[] carNames = {"test1", "test2", "test3"};
        RacingGame racingGame = new RacingGame(carNames, 5);
        assertThat(racingGame.racingCars.size()).isEqualTo(carNames.length);
    }

    @Test
    public void 차_움직임_기준치보다_낮을_때_움직이지않음() {
        Car testCar = Car.getCarInstance("test1");
        testCar.move(NOT_MOVING_RANDOM_NUM);

        assertThat(testCar.getMovingCount()).isEqualTo(0);
    }

    @Test
    public void 차_움직임_기준치보다_높을_때_움직임() {
        Car testCar = Car.getCarInstance("test1");
        testCar.move(MOVING_RANDOM_VALUE);
        assertThat(testCar.getMovingCount()).isEqualTo(1);
    }
}
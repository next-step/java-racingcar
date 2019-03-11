package car;

import car.entity.Car;
import car.entity.RacingGame;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {

    @Test
    public void initializeGame() {
        int carSize = 5;
        int tryCount = 3;
        RacingGame racingGame = new RacingGame(carSize,tryCount);
        List<Car> result = racingGame.racingCars;

        assertThat(result.size()).isEqualTo(carSize);
    }

    @Test
    public void carStatusStop() {
        int testRandomValue = 3;
        Car testCar = new Car();
        testCar.move(testRandomValue);

        assertThat(testCar.getMovingCount()).isEqualTo(0);
    }

    @Test
    public void carStatusStart() {
        int testRandomValue = 4;
        Car testCar = new Car();
        testCar.move(testRandomValue);

        assertThat(testCar.getMovingCount()).isEqualTo(1);
    }

}
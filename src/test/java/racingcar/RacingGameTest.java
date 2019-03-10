package racingcar;

import org.junit.Test;
import racingcar.random.CarMoveThresholdGenerator;
import racingcar.random.IntMoreThanCarMoveThresholdGenerator;
import racingcar.random.RandomIntGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void RacingGame_생성_시_자동차_셋업() {
        int numberOfCar = 3;
        RacingGame racingGame = new RacingGame(numberOfCar);
        List<Car> cars = racingGame.getCars();

        assertThat(cars)
                .hasSize(numberOfCar)
                .doesNotContain((Car) null);
    }

    @Test
    public void 전진하지않는_레이싱_경주() {
        int numberOfCar = 3;
        int tryCount = 5;
        RandomIntGenerator randomIntGenerator = new CarMoveThresholdGenerator();

        RacingGame racingGame = new RacingGame(numberOfCar, randomIntGenerator);
        racingGame.start(tryCount);

        List<Car> cars = racingGame.getCars();

        cars.forEach(car -> {
            assertThat(car.getMovedDistance()).isEqualTo(0);
        });
    }

    @Test
    public void 항상_전진하는_레이싱_경주() {
        int numberOfCar = 3;
        int tryCount = 5;
        RandomIntGenerator randomIntGenerator = new IntMoreThanCarMoveThresholdGenerator();

        RacingGame racingGame = new RacingGame(numberOfCar, randomIntGenerator);
        racingGame.start(tryCount);

        List<Car> cars = racingGame.getCars();

        cars.forEach(car -> {
            assertThat(car.getMovedDistance()).isEqualTo(tryCount);
        });
    }
}
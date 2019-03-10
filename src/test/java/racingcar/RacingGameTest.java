package racingcar;

import org.junit.Test;
import racingcar.random.CarMoveThresholdGenerator;
import racingcar.random.IntMoreThanCarMoveThresholdGenerator;
import racingcar.random.RandomIntGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private List<String> carNames = Arrays.asList("pobi", "crong", "honux");

    @Test
    public void RacingGame_생성_시_자동차_셋업() {
        RacingGame racingGame = new RacingGame(carNames);
        List<Car> cars = racingGame.getCars();

        assertThat(cars)
                .hasSize(carNames.size())
                .doesNotContainNull();
    }

    @Test
    public void RacingGame_생성_시_자동차_이름_셋업() {
        RacingGame racingGame = new RacingGame(carNames);
        List<Car> cars = racingGame.getCars();

        assertThat(cars.stream().map(Car::getName))
                .containsExactlyElementsOf(carNames);
    }

    @Test
    public void 전진하지않는_레이싱_경주() {
        int tryCount = 5;
        RandomIntGenerator randomIntGenerator = new CarMoveThresholdGenerator();

        RacingGame racingGame = new RacingGame(carNames, randomIntGenerator);
        racingGame.start(tryCount);

        List<Car> cars = racingGame.getCars();

        cars.forEach(car -> {
            assertThat(car.getMovedDistance()).isEqualTo(0);
        });
    }

    @Test
    public void 항상_전진하는_레이싱_경주() {
        int tryCount = 5;
        RandomIntGenerator randomIntGenerator = new IntMoreThanCarMoveThresholdGenerator();

        RacingGame racingGame = new RacingGame(carNames, randomIntGenerator);
        racingGame.start(tryCount);

        List<Car> cars = racingGame.getCars();

        cars.forEach(car -> {
            assertThat(car.getMovedDistance()).isEqualTo(tryCount);
        });
    }
}
package racing_game;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @Before
    public void setup() {
        this.racingGame = new RacingGame();
    }


    @Test
    public void 자동차_만들기() {
        final String[] carNames = {"pobi", "crong", "honux"};

        List<Car> cars = racingGame.createCars(carNames);

        assertThat(cars.size()).isEqualTo(carNames.length);
        assertThat(cars).allMatch(Objects::nonNull);
        assertThat(cars.stream().map(Car::getName).toArray()).isEqualTo(carNames);
    }

    @Test
    public void 가장큰숫자찾기() {
        final int maxMoveCount = 3;
        List<Car> testCars = createTestars(maxMoveCount);

        int findedMaxMoveCount = racingGame.findMaxMoveCount(testCars);

        assertThat(maxMoveCount).isEqualTo(findedMaxMoveCount);
    }

    @Test
    public void 우승자이름찾기() {
        final int maxMoveCount = 3;
        List<Car> testCars = createTestars(maxMoveCount);

        List<String> winnerNames = racingGame.findWinnerNames(testCars);

        assertThat(winnerNames.size()).isEqualTo(1);
        assertThat(winnerNames.get(0)).isEqualTo(String.valueOf(maxMoveCount));
    }

    private List<Car> createTestars(int carCount) {
        List<Car> cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new TestCar(String.valueOf(i + 1), i + 1));
        }

        return cars;
    }

}
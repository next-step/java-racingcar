package racingcar;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private String[] carNames = {"seo", "yeong", "sy"};

    @Test
    public void 차량_초기화() {
        RacingGame racingGame = new RacingGame(carNames);

        List<Car> cars = racingGame.getCars();
        assertThat(cars).hasSize(carNames.length);
    }

    @Test
    public void 이름_초기화() {
        RacingGame racingGame = new RacingGame(this.carNames);
        List<String> carNames = racingGame.getCars()
                                        .stream()
                                        .map(car -> car.getName())
                                        .collect(Collectors.toList());
        assertThat(carNames).containsAnyOf(this.carNames);
    }

    @Test
    public void 모든_차량_이동() {
        RacingGame racingGame = new RacingGame(carNames);
        List<Car> carPositions = racingGame.move(new RandomUtil(4,9));

        for(Car car : carPositions) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    public void 모든_차량_이동안함() {
        RacingGame racingGame = new RacingGame(carNames);
        List<Car> carPositions = racingGame.move(new RandomUtil(0,3));

        for(Car car : carPositions) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}

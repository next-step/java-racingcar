package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.util.FixedNumberGenerator;
import racing.util.RandomNumberGenerator;

class RacingGameTest {

    @DisplayName("생성자를 통해 자동차 리스트와 전진 수를 잘 생성하는지")
    @Test
    void setUpTest() {
        List<Car> cars = Arrays.asList(
                Car.create(new RandomNumberGenerator()),
                Car.create(new RandomNumberGenerator()),
                Car.create(new RandomNumberGenerator()),
                Car.create(new RandomNumberGenerator()),
                Car.create(new RandomNumberGenerator())
        );

        RacingGame newGame = RacingGame.setUp(1, cars);
        assertThat(newGame.getRoundCount()).isEqualTo(1);
        assertThat(newGame.getCars()).hasSize(5);
    }

    @DisplayName("게임이 시작되면 라운드 수 만큼의 결과 객체를 잘 반환하는지")
    @Test
    void startTest() {
        List<Car> cars = Arrays.asList(
                Car.create(new FixedNumberGenerator(5)),
                Car.create(new FixedNumberGenerator(5)),
                Car.create(new FixedNumberGenerator(5)),
                Car.create(new FixedNumberGenerator(3)),
                Car.create(new FixedNumberGenerator(3))
        );

        RacingGame newGame = RacingGame.setUp(1, cars);
        List<GameResult> results = newGame.start();
        assertThat(results).hasSize(1);
        List<Integer> expectedPositions = Arrays.asList(1, 1, 1, 0, 0);
        GameResult result = results.get(0);
        assertThat(result.getRoundResult()).isEqualTo(expectedPositions);
    }
}

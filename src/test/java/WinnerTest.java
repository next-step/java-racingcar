import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {
    @Test
    @DisplayName("우승자 찾기 테스트")
    public void findWinnerTest() {
        List<Car> challengers = List.of(
            new Car("honux", new Position(3)),
            new Car("pobi", new Position(2)),
            new Car("brown", new Position(1))
        );
        Cars cars = new Cars(challengers);
        RacingGame racingGame = new RacingGame(cars);
        racingGame.findWinner();
        assertThat(racingGame.winner.toString()).isEqualTo("honux");
    }

    @Test
    @DisplayName("여러 명의 우승자가 있을 경우")
    public void findWinnerTest2() {
        List<Car> challengers = List.of(
            new Car("honux", new Position(2)),
            new Car("pobi", new Position(2)),
            new Car("brown", new Position(1))
        );
        Cars cars = new Cars(challengers);
        RacingGame racingGame = new RacingGame(cars);
        racingGame.findWinner();
        assertThat(racingGame.winner.cars.size()).isEqualTo(2);
    }
}

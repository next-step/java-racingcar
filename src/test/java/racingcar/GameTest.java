package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class GameTest {

    @Test
    void gameTest_getCarsTest() {
        List<String> carNames = List.of("pobi", "honux");
        Game game = new Game(carNames);
        List<String> getCarNames = game.getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        Assertions.assertThat(getCarNames).contains("pobi", "honux");
    }

    @Test
    void gameTest_winnerTest() {
        List<String> carNames = List.of("pobi", "honux");
        Game game = new Game(carNames);
        String[] winners = game.getWinnerNames().toArray(new String[0]);
        Assertions.assertThat(carNames).contains(winners);
    }
}

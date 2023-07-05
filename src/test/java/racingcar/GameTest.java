package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameTest {

    @Test
    void gameTest_getCarsTest() {
        List<CarName> carNames = Stream.of("pobi", "honux").map(CarName::new).collect(Collectors.toList());
        Game game = new Game(carNames);
        List<CarName> getCarNames = game.getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        Assertions.assertThat(getCarNames).containsAll(carNames);
    }

    @Test
    void gameTest_winnerTest() {
        List<CarName> carNames = Stream.of("pobi", "honux").map(CarName::new).collect(Collectors.toList());
        Game game = new Game(carNames);
        Assertions.assertThat(carNames).containsAll(game.getWinnerNames());
    }
}

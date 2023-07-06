package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;
import racingcar.domain.Game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GameTest {

    @Test
    void gameTest_winnerTest() {
        List<CarName> carNames = Stream.of("pobi", "honux").map(CarName::new).collect(Collectors.toList());
        Game game = new Game(carNames);
        Assertions.assertThat(carNames).containsAll(game.findWinnerNames());
    }
}

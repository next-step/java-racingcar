package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.movable.FixedForwardStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinnerTest {
    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        List<String> carNames = new ArrayList<>(Arrays.asList("c", "java", "jpa"));
        racingGame = RacingGame.from(Cars.of(carNames, new FixedForwardStrategy(true)));
    }

    @Test
    void winnerTest() {
        racingGame.drive();
        assertThat(racingGame.judgeWinners().getResult()).containsExactly("c", "java", "jpa");
    }

    @Test
    void noWinnerTest() {
        assertThat(racingGame.judgeWinners().getResult().size()).isEqualTo(0);
    }

}

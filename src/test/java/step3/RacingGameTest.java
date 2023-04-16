package step3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    void 레이스테스트() {
        RacingGame racingGame = new RacingGame(3, 5);
        List<Integer> scoreList = new ArrayList<>();
        List<Integer> expectedScore = Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5);
        assertThat(racingGame.race(new MockDice(5), scoreList)).isEqualTo(expectedScore);
    }
}

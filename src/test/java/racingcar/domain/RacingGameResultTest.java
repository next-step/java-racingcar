package racingcar.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {
    private final int testPosition = 3;
    private final String resultWinnersString = "a, b";
    RacingGameResult racingGameResult = new RacingGameResult();

    @Before
    public void setUp() {
        Car firstWinner = new Car("a", testPosition);
        Car secondWinner = new Car("b",testPosition );
        racingGameResult.comparePosition(firstWinner, secondWinner);
    }

    @Test
    public void 우승자가_여러명인지_체크() {
        assertThat(racingGameResult.getWinners().size()).isEqualTo(2);
    }
}
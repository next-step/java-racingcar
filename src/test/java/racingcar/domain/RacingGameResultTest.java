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
        Car firstWinner = new Car(testPosition, "a");
        Car secondWinner = new Car(testPosition, "b");
        racingGameResult.comparePosition(testPosition, firstWinner);
        racingGameResult.comparePosition(testPosition, secondWinner);
    }

    @Test
    public void 우승자가_여러명인지_체크() {
        assertThat(racingGameResult.getWinners().size()).isEqualTo(2);
    }

    @Test
    public void 우승자명단확보() {
        String result = racingGameResult.parsingWinners();
        assertThat(result).isEqualTo(resultWinnersString);
    }
}
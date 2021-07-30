package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceManagerTest {

    private final RaceManager raceManager = new RaceManager();

    @Test
    @DisplayName("play 테스트 | carSize: 2, roundNumber: 3")
    public void play2Cars3Rounds() {
        // given
        CarNames carNames = new CarNames(Arrays.asList("iiaii", "!!e!!"));
        RoundNumber roundNumber = new RoundNumber(3);
        int expectedRoundRecordSize = 4;
        int winnerGteSize = 1;
        int winnerLteSize = 2;

        // when
        RaceResult raceResult = raceManager.play(carNames, roundNumber);
        int roundRecordSize = raceResult.getRoundRecords().size();
        int winnerSize = raceResult.getWinners().size();

        // then
        assertThat(roundRecordSize).isEqualTo(expectedRoundRecordSize);
        assertThat(winnerSize)
                .isGreaterThanOrEqualTo(winnerGteSize)
                .isLessThanOrEqualTo(winnerLteSize);
    }

    @Test
    @DisplayName("play 테스트 | carSize: 4, roundNumber: 5")
    public void play4Cars5Rounds() {
        // given
        CarNames carNames = new CarNames(Arrays.asList("iiaii", "!!e!!", "IIAII", "IIVII"));
        RoundNumber roundNumber = new RoundNumber(5);
        int expectedRoundRecordSize = 6;
        int winnerGteSize = 1;
        int winnerLteSize = 4;

        // when
        RaceResult raceResult = raceManager.play(carNames, roundNumber);
        int roundRecordSize = raceResult.getRoundRecords().size();
        int winnerSize = raceResult.getWinners().size();

        // then
        assertThat(roundRecordSize).isEqualTo(expectedRoundRecordSize);
        assertThat(winnerSize)
                .isGreaterThanOrEqualTo(winnerGteSize)
                .isLessThanOrEqualTo(winnerLteSize);
    }
}
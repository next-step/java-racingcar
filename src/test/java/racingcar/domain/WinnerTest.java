package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.fixture.RacingFixture;

import java.util.List;

class WinnerTest {

    @Test
    void winnerTest() {
        Winner winner = new Winner(RacingFixture.자동차_경주_기록_목록);
        List<String> winners = winner.getWinners();

        Assertions.assertThat(winners.get(0)).isEqualTo("pobi");
    }
}
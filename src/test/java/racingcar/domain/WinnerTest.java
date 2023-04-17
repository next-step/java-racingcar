package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static racingcar.domain.fixture.RecordsFixture.자동차_경주_기록_목록;
import static racingcar.domain.fixture.RecordsFixture.최종_우승자;

class WinnerTest {

    @Test
    @DisplayName("우승자를 판단한다.")
    void test() {
        // Given
        final Winner winner = new Winner(자동차_경주_기록_목록);

        // When
        final List<String> winners = winner.getWinners();

        // Then
        assertThat(winners).contains(최종_우승자);
    }
}
package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static racingcar.domain.fixture.RecordFixture.자동차_기록_목록;

class WinnerTest {

    @Test
    @DisplayName("우승자를 판단한다.")
    void test() {
        final Winner winner = new Winner(자동차_기록_목록);
        final List<String> winnerList = winner.judgeWinner();

        assertThat(winnerList).hasSize(1);
        assertThat(winnerList.get(0)).isEqualTo(자동차_기록_목록.get(2).getName());
    }
}
package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingHistoryTest {

    @DisplayName("레이싱 기록에 각 단계 1st 순위 이름들을 확인한다.")
    @Test
    void createTest() {
        RacingHistory racingHistory = new RacingHistory(List.of("racer"), "racer : -");

        assertThat(racingHistory).isNotNull();
        assertThat(racingHistory.getFirstRankNames()).containsExactly("racer");
    }

}
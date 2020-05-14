package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.game.PhaseResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PhaseResultTest {

    @DisplayName("한번 이동 시도후 결과 List를 반환한다.")
    @Test
    void getPhaseResult() {
        List<Integer> raceResults = Arrays.asList(1, 0, 1);
        PhaseResult phaseResult = new PhaseResult(raceResults);

        assertThat(phaseResult.getRaceResult()).containsExactly(1, 0, 1);
    }
}

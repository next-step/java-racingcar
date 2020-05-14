package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.game.GameResult;
import racingcar.domain.game.PhaseResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameResultTest {
    @DisplayName("시도 번호에 맞는 PhaseResult를 반환받는다.")
    @Test
    void findByPhaseNumber() {
        PhaseResult phaseResult = new PhaseResult(Arrays.asList(1, 0, 1));
        List<PhaseResult> phaseResults = new ArrayList<>();
        phaseResults.add(phaseResult);

        GameResult gameResult = new GameResult(1, phaseResults);

        PhaseResult findPhaseResult = gameResult.findByPhaseNumber(1);
        assertThat(findPhaseResult.getRaceResult()).isEqualTo(phaseResult.getRaceResult());
    }

    @DisplayName("전체 게임 시도 횟수보다 크거나 1보다 작은 값은 IllegalArgumentException을 throw 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 2})
    void findByPhaseNumberThrowsException(int wrongPhaseNumber) {
        PhaseResult phaseResult = new PhaseResult(Arrays.asList(1, 0, 1));
        List<PhaseResult> phaseResults = new ArrayList<>();
        phaseResults.add(phaseResult);

        GameResult gameResult = new GameResult(1, phaseResults);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> gameResult.findByPhaseNumber(wrongPhaseNumber))
                .withMessage(String.format("잘못된 시도 번호입니다. - %d\n", wrongPhaseNumber));
    }
}

package racingcar.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.CarMoveResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameResultTest {

    private List<PhaseResult> phaseResults;
    private PhaseResult phaseResult;

    @BeforeEach
    void setUp() {
        List<CarMoveResult> expectedResults = new ArrayList<>();

        expectedResults.add(new CarMoveResult("pobi", 1));
        expectedResults.add(new CarMoveResult("crong", 0));
        expectedResults.add(new CarMoveResult("horox", 1));

        phaseResult = new PhaseResult(expectedResults);

        phaseResults = new ArrayList<>();

        phaseResults.add(phaseResult);
    }

    @DisplayName("시도 번호에 맞는 PhaseResult를 반환받는다.")
    @Test
    void findByPhaseNumber() {
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
        List<PhaseResult> phaseResults = new ArrayList<>();
        phaseResults.add(phaseResult);

        GameResult gameResult = new GameResult(1, phaseResults);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> gameResult.findByPhaseNumber(wrongPhaseNumber))
                .withMessage(String.format("잘못된 시도 번호입니다. - %d\n", wrongPhaseNumber));
    }

    @DisplayName("게임 우승자의 이름 List를 반환한다.")
    @Test
    void findWinners() {
        GameResult gameResult = new GameResult(1, phaseResults);

        assertThat(gameResult.findWinners()).contains("pobi", "horox");
    }
}

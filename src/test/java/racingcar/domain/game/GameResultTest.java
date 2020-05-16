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

    @DisplayName("게임 우승자의 이름 List를 반환한다.")
    @Test
    void findWinners() {
        GameResult gameResult = new GameResult(phaseResults);

        assertThat(gameResult.findWinners()).contains("pobi", "horox");
    }
}

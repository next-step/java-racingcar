package racingcar.vo.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.vo.game.GameInfo;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameInfoTest {

    @DisplayName("시도 회수 0 보다 작을 경우 IllegalArgumentException을 throw 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -3})
    void ThrowException(int numberOfPhase) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameInfo("pobi", numberOfPhase))
                .withMessage("시도할 횟수는 0 보다 커야합니다.");
    }
}

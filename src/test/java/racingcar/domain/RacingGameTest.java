package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameTest {
    private MovableStrategy movableStrategy = () -> true;

    @DisplayName("생성 시 라운드 수가 0 이하일 경우 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @ValueSource(ints = {-5, 0})
    void create_ThrowsIllegalArgumentException_IfCarCountOrRoundCountUnderOne(int roundCount) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RacingGame(roundCount, movableStrategy));
    }
}

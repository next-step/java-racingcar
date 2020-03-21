package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @ParameterizedTest
    @DisplayName("실행수 입력 값이 1이상이 아니면 IllegalArgumentException 테스트")
    @ValueSource(ints = {0, -1, -99})
    void validateRunCountTest(int runCount) {
        assertThatThrownBy(() -> {
                    RacingGame racingGame = new RacingGame(3);
                    racingGame.startRacing(runCount);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("Car 총 갯수 입력 값이 1이상이 아니면 IllegalArgumentException 테스트")
    @ValueSource(ints = {0, -1, -99})
    void validateCarTotalCountTest(int carTotalCount) {
        assertThatThrownBy(() -> {
                    RacingGame racingGame = new RacingGame(carTotalCount);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}

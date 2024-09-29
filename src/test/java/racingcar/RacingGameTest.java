package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RacingGameException;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 자동차의_갯수는_최소_1대_이상이다(int round) {
        assertThatNoException().isThrownBy(() -> {
            RacingGame racingGame = new RacingGame(round, 1);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void 자동차의_갯수_1대_미만이면_오류(int round) {
        assertThatThrownBy(() -> {
            RacingGame racingGame = new RacingGame(round, 1);
        }).isInstanceOf(RacingGameException.class)
                .hasMessage("자동차는 최소 1대 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 이동은_최소_1번_이상이다(int movement) {
        assertThatNoException().isThrownBy(() -> {
            RacingGame racingGame = new RacingGame(1, movement);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void 이동_1번_미만_오류(int movement) {
        assertThatThrownBy(() -> {
            RacingGame racingGame = new RacingGame(1, movement);
        }).isInstanceOf(RacingGameException.class)
                .hasMessage("이동은 최소 1번 이상이어야 합니다.");
    }
}

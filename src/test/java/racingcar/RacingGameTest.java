package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RacingGameException;

public class RacingGameTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 자동차의_갯수는_최소_1대_이상이다(int round) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            RacingGame racingGame = new RacingGame(round);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void 자동차의_갯수는_최소_1대_미만이면_오류(int round) {
        Assertions.assertThatThrownBy(() -> {
                    RacingGame racingGame = new RacingGame(round);
                }).isInstanceOf(RacingGameException.class)
                .hasMessage("자동차는 최소 1대 이상이어야 합니다.");
    }
}

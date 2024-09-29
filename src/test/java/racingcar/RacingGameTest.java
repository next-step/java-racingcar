package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.PositiveNumberException;
import racingcar.exception.RacingGameException;

import static org.assertj.core.api.Assertions.*;

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
        }).isInstanceOf(PositiveNumberException.class)
                .hasMessage("음수는 입력될 수 없습니다.");
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
        }).isInstanceOf(PositiveNumberException.class)
                .hasMessage("음수는 입력될 수 없습니다.");
    }

    @Test
    void 경기실행_결과를_문자열로_출력한다() {
        RacingGame racingGame = new RacingGame(3, 5);
        String actual = racingGame.runAndResult((car) -> 4);
        String expected = expectedRunAndResult();

        assertThat(actual).isEqualTo(expected);
    }

    private String expectedRunAndResult() {
        int movementCount = 5;

        StringBuilder result = new StringBuilder();
        for (int index = 1; index <= movementCount; index++) {
            result.append(expectedOneMovementResult(index));
        }
        return result.toString();
    }

    private String expectedOneMovementResult(int outerIndex) {
        int carCount = 3;
        int movementCount = 5;
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < carCount; index++) {
            result.append("-".repeat(outerIndex)).append("\n");
        }
        if (outerIndex < movementCount) {
            result.append("\n");
        }
        return result.toString();
    }

}

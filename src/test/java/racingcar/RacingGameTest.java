package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class RacingGameTest {

    @DisplayName("실행 횟수가 양수인 경우 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"5", "11", " 11 ", "7 "})
    void 자동차_실행_횟수_검증_성공(String count) {
        assertThatNoException()
                .isThrownBy(() -> new RacingGame(null, count));
    }

    @DisplayName("실행 횟수가 음수이거나 정수가 아닌 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"5.1", "-999", " ARA ", "1 1"})
    void 자동차_실행_횟수_검증_실패(String count) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new RacingGame(null, count))
                .withMessageMatching(RacingGame.NON_POSITIVE_EXCEPTION_MESSAGE);
    }

    @Test
    void 자동자_경주_정상_동작() {
        Cars cars = new Cars("pobi,crong,honux");
        RacingGame racingGame = new RacingGame(cars, "5");

        assertThatNoException()
                .isThrownBy(() -> racingGame.play());
    }

}

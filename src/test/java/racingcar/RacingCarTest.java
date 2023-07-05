package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


public class RacingCarTest {

    @DisplayName("유효한 자동차 이름일 경우 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "a", " a "})
    void 자동차_입력_검증_성공(String carNames) {
        assertThatNoException()
                .isThrownBy(() -> new Cars(carNames));
    }

    @DisplayName("유효하지 않은 자동차 이름일 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,croong,honux", "pobi,,honux", "", ",,,," })
    void 자동차_입력_검증_실패(String carNames) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Cars(carNames))
                .withMessageMatching("자동차 이름이 유효하지 않습니다");
    }


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
                .withMessageMatching("실행 횟수는 양수만 가능합니다");
    }

}

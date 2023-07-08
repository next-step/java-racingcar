package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class CarNameTest {
    @DisplayName("유효한 자동차 이름을 받는 경우 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux", "a", " a ", " 123"})
    void 유효한_자동차_이름(String name) {
        assertThatNoException()
                .isThrownBy(() -> new CarName(name));
    }

    @DisplayName("유효하지 않은 자동차 이름을 받는 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"croong", "", "    a          b    "})
    void 유효하지_않은_자동차_이름(String inputText) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarNames(inputText));
    }
}

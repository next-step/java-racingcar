package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class ElementsTest {

    @DisplayName("양수로만 이루어진 경우 예외가 발생하지 않는다")
    @Test
    void 문자열_검증_성공() {
        String[] elements = {"1", "2", "3"};

        assertThatNoException().isThrownBy(() -> new Elements(elements));
    }

    @DisplayName("음수가 존재하는 경우 RuntimeException 예외가 발생한다")
    @Test
    void 문자열_검증_실패_음수() {
        String[] elements = {"1", "-2", "3"};

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Elements(elements))
                .withMessageMatching("0이상 9이하의 숫자만 가능합니다");
    }

    @DisplayName("숫자 이외의 값이 존재하는 경우 RuntimeException 예외가 발생한다")
    @Test
    void 문자열_검증_실패_숫자외의_값() {
        String[] elements = {"aaa", "4", "-5", "6"};

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Elements(elements))
                .withMessageMatching("0이상 9이하의 숫자만 가능합니다");
    }
}

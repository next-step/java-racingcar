package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorMainTest {

    @ParameterizedTest
    @ValueSource(strings = {"1 + 5 - 2 * 10 / 2",
            "10 * 5 / 2 + 3 - 4",
            "8 - 3 + 12 / 1 * 5",
            "9 / 3 + 10 - 2 * 1"})
    @DisplayName("사칙연산 문자열 입력값 통과 테스트")
    void checkInputStringPassTest(String input) {
        boolean result = CalculatorMain.checkInputString(input);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사칙연산 문자열 입력값 실패 테스트")
    void checkInputStringFailTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> CalculatorMain.checkInputString(input))
                .withMessageMatching("null 또는 빈값을 입력할 수 없습니다");
    }
}

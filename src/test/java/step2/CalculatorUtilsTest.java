package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("Step2 - 계산기 유틸 테스트")
class CalculatorUtilsTest {

    @DisplayName("정상적인 입력값")
    @ParameterizedTest
    @ValueSource(strings = {"4 * 6 * 7 - 8 / 9", "8 / 4 * 1 + 3 - 1"})
    void inputValidator_성공(String testInput) {
        CalculatorUtils.inputValidator(testInput);
    }

    @DisplayName("비정상적인 입력값")
    @ParameterizedTest
    @ValueSource(strings = {""," ","4 6 6 * 7 - 8 / 9", "! % *", "4 % 6 # 7 @ 8 / 9", "2 + 10 * 4 /", "/ 3 * 5"})
    void inputValidator_실패1(String testInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculatorUtils.inputValidator(testInput);
        });
    }
}

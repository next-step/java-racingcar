package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


@DisplayName("Step2 - 계산기 유틸 테스트")
class CalculatorUtilsTest {

    @DisplayName("정상적인 입력값")
    @Test
    void inputValidator_성공() {
        String testInput = "4 * 6 * 7 - 8 / 9";
        CalculatorUtils.inputValidator(testInput);
    }

    @DisplayName("비정상적인 입력값1")
    @Test
    void inputValidator_실패1() {
        String testInput = "4 6 6 * 7 - 8 / 9";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculatorUtils.inputValidator(testInput);
        });
    }

    @DisplayName("비정상적인 입력값2")
    @Test
    void inputValidator_실패2() {
        String testInput = "! % *";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculatorUtils.inputValidator(testInput);
        });
    }

    @DisplayName("입력값이 없음")
    @Test
    void inputValidator_실패3() {
        String testInput = "";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculatorUtils.inputValidator(testInput);
        });
    }

    @DisplayName("처리할 수 없는 연산자")
    @Test
    void inputValidator_실패4() {
        String testInput = "4 % 6 # 7 @ 8 / 9";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculatorUtils.inputValidator(testInput);
        });
    }
}
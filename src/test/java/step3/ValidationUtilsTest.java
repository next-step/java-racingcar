package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidationUtilsTest {

    @Test
    @DisplayName("입력받은 숫자가 0 이하인 경우 예외 처리 테스트")
    void isBiggerThanZero() {
        int value = 0;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidationUtils.isBiggerThanZero(value);
        });
    }

    @Test
    @DisplayName("숫자가 0보다 작거나 9보다 클 경우의 예외 처리 테스트")
    void isSingleDigitNumber() {
        int value = 10;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidationUtils.isSingleDigitNumber(value);
        });
    }

    @Test
    @DisplayName("문자열의 공백을 제거하였을 때 null 또는 Empty 여부를 잘 검증하는지 테스트")
    void isNull() {
        String value = null;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidationUtils.isNullOrEmpty(value);
        });
    }

    @Test
    void isEmpty() {
        String value = "  ";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidationUtils.isNullOrEmpty(value);
        });
    }
}

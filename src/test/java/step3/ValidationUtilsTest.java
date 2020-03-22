package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidationUtilsTest {

    @Test
    @DisplayName("게임을 수행할 차 대수가 0 이하일 경우의 예외 처리 테스트")
    void validateCarCountException() {
        int carCount = 0;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidationUtils.validateCarCount(carCount);
        });
    }

    @Test
    @DisplayName("게임을 수행할 회차 수가 0 이하일 경우의 예외 처리 테스트")
    void validateRoundTimeException() {
        int roundTime = 0;

        assertThatIllegalArgumentException().isThrownBy(() ->  {
            ValidationUtils.validateRoundTime(roundTime);
        });
    }

    @Test
    @DisplayName("랜덤으로 뽑은 숫자가 0보다 작거나 9보다 클 경우의 예외 처리 테스트")
    void validateRandomValueException() {
        int randomValue = 10;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidationUtils.validateRandomValue(randomValue);
        });
    }
}

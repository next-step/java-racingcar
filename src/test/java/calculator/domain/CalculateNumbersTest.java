package calculator.domain;

import calculator.domain.CalculateNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculateNumbersTest {

    @Test
    @DisplayName("숫자 예외처리")
    void throwNumberException() {
        String[] inputs = {"!","/","3","4"};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CalculateNumbers(inputs);
        })
                .withMessageContaining("숫자가 아닙니다.");
    }

    @Test
    @DisplayName("널 예외처리")
    void throwNullOrEmptyException() {
        String[] inputs = {};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CalculateNumbers(inputs);
        })
                .withMessageContaining("입력 값이 없습니다.");

        String[] inputs2 = null;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CalculateNumbers(inputs2);
        })
                .withMessageContaining("입력 값이 없습니다.");
    }

}

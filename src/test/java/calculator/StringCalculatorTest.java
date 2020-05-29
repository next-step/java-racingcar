package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {
    private StringCalculator cal;

    @BeforeEach
    public void setup() {
        cal = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException을 발생시킨다")
    @NullAndEmptySource
    void isBlank(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            cal.add(input);
        });
    }
}
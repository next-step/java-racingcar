package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setup() {
        this.stringCalculator = new StringCalculator();
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다")
    @Test
    public void test() {
        Integer result1 = this.stringCalculator.enterExpression(null);
        Integer result2 = this.stringCalculator.enterExpression("");

        assertAll(
                () -> assertThat(result1).isEqualTo(0),
                () -> assertThat(result2).isEqualTo(0)
        );
    }

}

package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.NotPositiveNumberException;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

    @Test
    void sum_null_또는_빈문자() {
        int result = StringAddCalculator.sum(null);
        assertThat(result).isZero();

        result = StringAddCalculator.sum("");
        assertThat(result).isZero();
    }

    @Test
    void sum_숫자하나() {
        int result = StringAddCalculator.sum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void sum_쉼표구분자() {
        int result = StringAddCalculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void sum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.sum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void sum_custom_구분자() {
        int result = StringAddCalculator.sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void sum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.sum("-1,2,3"))
            .isInstanceOf(NotPositiveNumberException.class);
    }
}

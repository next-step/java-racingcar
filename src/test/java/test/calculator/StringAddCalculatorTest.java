package test.calculator;

import calculator.StringAddCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAddCalculatorTest {

    @Test
    void 빈문자열_null_space() {
        StringAddCalculator cal = new StringAddCalculator();
        int inputEmpty = cal.calculate("");
        int inputNull = cal.calculate(null);
        assertThat(inputEmpty).isEqualTo(0);
        assertThat(inputNull).isEqualTo(0);
    }

    @Test
    void 문자열_하나() {
        int number = new StringAddCalculator().calculate("1");
        assertThat(number).isEqualTo(1);
    }

    @Test
    void 컴마_구분자_더하기() {
        int sum = new StringAddCalculator().calculate("1,2");
        assertThat(sum).isEqualTo(3);
    }

    @Test
    void 다중_구분자_더하기() {
        int sum = new StringAddCalculator().calculate("1,2:3");
        assertThat(sum).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_더하기() {
        int sum = new StringAddCalculator().calculate("//;\n1;2;3");
        assertThat(sum).isEqualTo(6);
    }

    @Test
    void 음수_익셉션() {
        assertThrows(RuntimeException.class, () -> {
            new StringAddCalculator().calculate("-1,2,3");
        });
    }
}

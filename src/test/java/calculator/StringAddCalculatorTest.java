package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringAddCalculatorTest {
    @Test
    void 빈_문자열_공백문자_일때() {
       assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
       assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void 숫자하나를_입력할경우_해당숫자반환() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 숫자_두개를_컴마구분자로_입력할경우_두숫자합_반환() {
        assertThat(StringAddCalculator.splitAndSum("1,4")).isEqualTo(5);
    }

    @Test
    void 숫자를_컴마이외_콜론을_사용하여_두숫자합_반환() {
        assertThat(StringAddCalculator.splitAndSum("1:5")).isEqualTo(6);
    }

    @Test
    void 쉼표와_콘론구분자가_같이있는_숫자의_합_반환() {
        assertThat(StringAddCalculator.splitAndSum("1:2,3")).isEqualTo(6);
    }

    @Test
    void 특정_문자_사이에_커스텀_구분자로_모든_숫자합_반환() {
        int result = StringAddCalculator.splitAndSum("//'\n1'2'3'4");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 음수가_포함될경우_RuntimeException_발생() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> StringAddCalculator.splitAndSum("1,2,-1"));
    }

    @Test
    void 커스텀_구분자에_음수가_포함된_경우_RuntimeException_발생() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> StringAddCalculator.splitAndSum("//;\n1;2;-5"));
    }
}

package study;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private StringCalculator stringCalculator = new StringCalculator();
    private final int ZERO = 0;

    @Test
    void 빈문자열_또는_NULL입력받았을때_0으로반환한다() {
        assertThat(stringCalculator.calculate(null)).isEqualTo(ZERO);
        assertThat(stringCalculator.calculate("")).isEqualTo(ZERO);
    }

    @Test
    void 숫자하나를입력받을때_해당숫자로변환해서반환한다() {
        assertThat(stringCalculator.calculate("1")).isEqualTo(1);
        assertThat(stringCalculator.calculate("2")).isEqualTo(2);
    }

    @Test
    void 숫자두개를컴마로구분자로입력할경우_숫자의합을반환한다() {
        assertThat(stringCalculator.calculate("1,2")).isEqualTo(3);
        assertThat(stringCalculator.calculate("2,2")).isEqualTo(4);
    }

    @Test
    void 구분자를컴마이외에콜론을사용했을경우_숫자의합을반환한다() {
        assertThat(stringCalculator.calculate("1:2")).isEqualTo(3);
        assertThat(stringCalculator.calculate("2:2")).isEqualTo(4);
    }

    @Test
    void 문자사이에커스텀구분자를지정했을경우_숫자의합을반환한다() {
        assertThat(stringCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수를전달할경우_RuntimeException예외가발생해야한다() {
        assertThatThrownBy(
            () -> stringCalculator.calculate("-1,2,3")
        ).isInstanceOf(RuntimeException.class);
    }


}

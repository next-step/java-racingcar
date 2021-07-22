package stage2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stage2.stringcalculator.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("덧셈")
    public void addition() throws Exception {
        int result = StringCalculator.calculation("2 + 4");
        System.out.println("결과 : " + result);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("뺄셈")
    public void subtraction() throws Exception {
        int result = StringCalculator.calculation("2 - 4");
        System.out.println("결과 : " + result);
        assertThat(result).isEqualTo(-2);
    }

    @Test
    @DisplayName("곱셈")
    public void multiplication() throws Exception {
        int result = StringCalculator.calculation("2 * 4");
        System.out.println("결과 : " + result);
        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("나눗셈")
    public void division() throws Exception {
        int result = StringCalculator.calculation("4 / 4");
        System.out.println("결과 : " + result);
        assertThat(result).isEqualTo(1);
    }
}

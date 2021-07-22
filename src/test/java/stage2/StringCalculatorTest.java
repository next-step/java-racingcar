package stage2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stage2.stringcalculator.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    private void print(int result) {
        System.out.println("결과 : " + result);
        System.out.println();
    }

    @Test
    @DisplayName("덧셈")
    public void addition() {
        int result = StringCalculator.calculation("2 + 4");
        print(result);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("뺄셈")
    public void subtraction() {
        int result = StringCalculator.calculation("2 - 4");
        print(result);
        assertThat(result).isEqualTo(-2);
    }

    @Test
    @DisplayName("곱셈")
    public void multiplication() {
        int result = StringCalculator.calculation("2 * 4");
        print(result);
        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("나눗셈")
    public void division() {
        int result = StringCalculator.calculation("4 / 4");
        print(result);
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    public void 사칙연산_기호가_아닌_경우() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            int result = StringCalculator.calculation("4 @ 4");
            print(result);
        });
    }
}

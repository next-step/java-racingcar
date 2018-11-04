package calculator;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculate( "2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.calculate( "2 - 3");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculate( "6 / 3");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculate( "2 * 8");
        assertThat(result).isEqualTo(16);
    }

    @Test
    public void 종합테스트() {
        int result = StringCalculator.calculate( "9 + 2 - 3 / 2");
        assertThat(result).isEqualTo(4);
        result = StringCalculator.calculate( "2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Test(expected=IllegalArgumentException.class)
    public void 공백테스트() {
        StringCalculator.calculate( "");
    }

    @Test(expected=NullPointerException.class)
    public void 널테스트()  {
        StringCalculator.calculate(null);

    }
}
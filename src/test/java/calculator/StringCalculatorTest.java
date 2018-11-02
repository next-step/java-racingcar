package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void 더하기(){
        int result = StringCalculator.calculate("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺴기(){
        int result = StringCalculator.calculate("7 - 2");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 나누기(){
        int result = StringCalculator.calculate("8 / 2");
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 곱하기(){
        int result = StringCalculator.calculate("4 * 3");
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void split_길이테스트(){
        String text = "4 + 3";
        String[] values = text.split(" ");
        assertThat(values.length).isEqualTo(3);
    }

}
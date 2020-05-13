package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void plusTest(){

        // given
        String input = "1 + 3 + 4";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void minusTest(){

        // given
        String input = "1 - 3";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(-2);
    }

    @Test
    public void multipleTest(){

        // given
        String input = "4 * 5";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(20);
    }

    @Test
    public void divideTest(){

        // given
        String input = "5 / 2";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"5 / 2 + 3 * 4 - 1, 19", "4 + 1 - 2 * 3 - 1 / 2, 4"})
    public void complexCalculateTest(String input, int expected){

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값이 null 이거나 빈 공백일 시 IllegalArgumentException 이 발생한다")
    public void nullOrEmptyTest(){

        // given
        String input1 = null;
        String input2 = "";

        // then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input1);
        });

        // then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input2);
        });
    }

    @Test
    @DisplayName("사칙연산이 아닌 기호 입력 시 IllegalArgumentException 이 발생한다")
    public void operationCheckTest(){

        // given
        String input = "1 = 1";

        // then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        });
    }

}

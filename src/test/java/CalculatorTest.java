import calculator.Calculator;
import calculator.CalculatorImpl;
import calculator.Checker;
import calculator.CheckerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {
    public Calculator calculator = new CalculatorImpl();
    private Checker checker = new CheckerImpl();


    @DisplayName("1+2+3=6")
    @Test
    void shouldSuccessToPlusResultForCorrectResult(){
        String[] target = {"1", "+", "2", "+", "3"};
        int result = calculator.calculate(Arrays.asList(target));
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("1+2+3 != 5")
    @Test
    void shouldFailToPlusResultForInCorrectResult(){
        String[] target = {"1", "+", "2", "+", "3"};
        int result = calculator.calculate(Arrays.asList(target));
        assertThat(result).isNotEqualTo(5);
    }

    @DisplayName("1-2-3 != -4")
    @Test
    void shouldSuccessToMinusResultForCorrectResult(){
        String[] target = {"1", "-", "2", "-", "3"};
        int result = calculator.calculate(Arrays.asList(target));
        assertThat(result).isEqualTo(-4);
    }

    @DisplayName("1-2-3 != -4")
    @Test
    void shouldFailToMinusResultForInCorrectResult(){
        String[] target = {"1", "-", "2", "-", "3"};
        int result = calculator.calculate(Arrays.asList(target));
        assertThat(result).isNotEqualTo(-5);
    }

    @DisplayName("1*2*3 == 6")
    @Test
    void shouldSuccessToMultiplyResultForCorrectResult(){
        String[] target = {"1", "*", "2", "*", "3"};
        int result = calculator.calculate(Arrays.asList(target));
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("1*2*3 != 5")
    @Test
    void shouldFailToMultiplyResultForInCorrectResult(){
        String[] target = {"1", "*", "2", "*", "3"};
        int result = calculator.calculate(Arrays.asList(target));
        assertThat(result).isNotEqualTo(5);
    }

    @DisplayName("1/2/3 == 0")
    @Test
    void shouldSuccessToDivResultForCorrectResult(){
        String[] target = {"1", "/", "2", "/", "3"};
        int result = calculator.calculate(Arrays.asList(target));
        System.out.println("result:" + result);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("1/2/3 != 0")
    @Test
    void shouldFailToDivResultForInCorrectResult(){
        String[] target = {"1", "/", "2", "*", "2"};
        int result = calculator.calculate(Arrays.asList(target));
        System.out.println("result: "+ result);
        assertThat(result).isNotEqualTo(1);
    }

    @DisplayName("11 + 22 * 3 / 11 = 9")
    @Test
    void test(){
        String[] target = {"11", "+", "2", "+", "3"};
        int result = calculator.calculate(Arrays.asList(target));
        assertThat(result).isEqualTo(16);
    }

    @Test
    void errorTest(){
        assertThatThrownBy(() -> {
            checker.throwNotCorrectSign();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You should only sign word.");
    }

    @Test
    void emptyErrorTest(){
        assertThatThrownBy(() -> {
            String inputText = " ";
            String removedBlankText = inputText.replace(" ","");
            checker.checkBlank(removedBlankText);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You should not input blank.");
    }
}
package study;

import main.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @ParameterizedTest
    @NullAndEmptySource
    void inputNullTest(String input) {
        try{
            calculator.calculate(input);
        }catch (NullPointerException ie){

        }catch(NumberFormatException ne){

        }
    }
    @DisplayName("disabledTEST")
    @ParameterizedTest
    @CsvSource("1 + 2 , 3")
    void inputDisabledCharacterTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.getcalRes();
        });
    }

    public static void main(String[] args) {
        System.out.println("-----");
        new Calculator().calculate("1 + 2");
        System.out.println("-----");
    }
}

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
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }
    @DisplayName("특수 문자 예외")
    @ParameterizedTest
    @CsvSource("1 + 2 , 3")
    void inputDisabledCharacterTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
            calculator.getcalRes();
        });
    }
}

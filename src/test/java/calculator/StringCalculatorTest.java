package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import validator.EmptyInputValidator;
import validator.IValidator;
import validator.OperatorValidator;
import validator.ValidationChecker;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp(){
        List<IValidator> validators = new ArrayList<>();
        validators.add(new EmptyInputValidator());
        validators.add(new OperatorValidator());
        ValidationChecker validationChecker = new ValidationChecker(validators);

        Calculator calculator = new Calculator();

        stringCalculator = new StringCalculator(validationChecker, calculator);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 , 10", "2 + 3 * 4 * 2 + -5,35"})
    @DisplayName("StringCalculator 통합 테스트")
    void integratedTest(String input, int expected){
        assertThat(stringCalculator.calculate(input)).isEqualTo(expected);
    }
}

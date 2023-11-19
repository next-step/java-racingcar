package calculator.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void validateForBlankTest(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> StringValidator.validateForBlank(input));
    }
}

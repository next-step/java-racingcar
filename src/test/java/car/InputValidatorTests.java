package car;

import car.service.InputType;
import car.service.InputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTests {

    @Test
    @DisplayName("input값이 양수인 경우")
    void validatePositive_positiveInput_doesNotThrowException() {
        // given
        int input = 3;
        InputType inputType = InputType.CAR_COUNT;

        // when, then
        Assertions.assertDoesNotThrow(() -> InputValidator.validatePositive(input, inputType));
    }

    @Test
    @DisplayName("input값이 0 경우")
    void validatePositive_zero_throwsIllegalArgumentException() {
        // given
        int input = 0;
        InputType inputType = InputType.CAR_COUNT;

        // when, then
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validatePositive(input, inputType));
        Assertions.assertEquals(inputType.getRangeErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("input값이 -1인 경우")
    void validatePositive_negativeInput_throwsIllegalArgumentException() {
        // given
        int input = -1;
        InputType inputType = InputType.CAR_COUNT;

        // when, then
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validatePositive(input, inputType));
        Assertions.assertEquals(inputType.getRangeErrorMessage(), exception.getMessage());
    }
}

package controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void shouldValidateCarName_whenCarNameIsLong() {
        String longName = "carwithLooooooongName";
        InputValidator validator = new InputValidator();
        Assertions.assertThatThrownBy(() -> validator.validateName(new String[]{longName})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldValidateCarName_whenNormalCond() {
        String normalName = "devcs";
        InputValidator validator = new InputValidator();
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> validator.validateName(new String[]{normalName}));
    }
}

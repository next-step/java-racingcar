package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserInputValidationTest {

    @ParameterizedTest
    @DisplayName("빈값 예외 테스트")
    @ValueSource(strings = {"+", " ", "^"})
    public void isStringEmpty(String inputValue) {
        assertThat(UserInputValidation.isStringEmpty(inputValue)).isFalse();
    }
}
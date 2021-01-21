package calculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ValidateUtilsTest {

    @Test
    void validateInput() {
        String[] inputArray1 = {" ", " ", " "};
        assertThat(ValidateUtils.validateInput(inputArray1)).isFalse();
        String[] inputArray2 = {"2", "*", "3", "-", "4", "/", "2"};
        assertThat(ValidateUtils.validateInput(inputArray2)).isTrue();
        String[] inputArray3 = {"2", "3", "4"};
        assertThat(ValidateUtils.validateInput(inputArray3)).isFalse();
        String[] inputArray4 = {"+", "*", "-"};
        assertThat(ValidateUtils.validateInput(inputArray4)).isFalse();
        String[] inputArray5 = {"+", "2", "-"};
        assertThat(ValidateUtils.validateInput(inputArray5)).isFalse();
        String[] inputArray6 = {"+", "2", "-", "*"};
        assertThat(ValidateUtils.validateInput(inputArray6)).isFalse();
    }
}
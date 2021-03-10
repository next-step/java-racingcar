package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    public Util util = new Util();

    @ParameterizedTest
    @ValueSource(strings = {"p y t h o n !"})
    @DisplayName("Test for string spliter in Util.class")
    void testStringSpliter(String value) {
        assertThat(util.splitString(value))
                .isEqualTo(new String[] {"p", "y", "t", "h", "o", "n", "!"});
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Test for invalid input data - null or empty string")
    void handleInvalidData(String value) {
        assertThatThrownBy(() -> {
            util.checkInvalidValue(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Value cannot be null or empty");
    }


    @ParameterizedTest
    @ValueSource(strings = {"^", "%", "#", "!", "@"})
    @DisplayName("Test for invalid operator")
    void handleInvalidOperator(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    util.checkInvalidOperator(value);
                }).withMessageMatching("Operator is invalid");
    }


}
package calculator;

import calculator.utils.StringUtil;
import calculator.utils.ValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ValidationUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"p y t h o n !"})
    @DisplayName("Test for string spliter in Util.class")
    void testStringSpliter(String value) {
        assertThat(StringUtil.splitString(value))
                .isEqualTo(new String[] {"p", "y", "t", "h", "o", "n", "!"});
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Test for invalid input data - null or empty string")
    void handleInvalidData(String value) {
        assertThatThrownBy(() -> {
            ValidationUtil.checkInvalidValue(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Value cannot be null or empty");
    }

}
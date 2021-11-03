package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputValidatorTest {

    @DisplayName("String null이거나 Empty 값이 나오면 IllegalException")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputValidator.isNullOrEmptyForString(input);
        });
    }

    @DisplayName("String이 Number가 아니면 IllegalException")
    @ParameterizedTest
    @ValueSource(strings = {"k", "한글", "test"})
    void notNumberTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputValidator.isNumberForString(input);
        });
    }


    @DisplayName("Long 값이 null 이면 IllegalException")
    @ParameterizedTest
    @NullSource
    void nullTest(Integer input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputValidator.isNull(input);
        });
    }

}
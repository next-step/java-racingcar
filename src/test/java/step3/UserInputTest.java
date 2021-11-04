package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserInputTest {

    @DisplayName("String null이거나 Empty 값이 나오면 IllegalException")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(String input) {
        UserInput userInput = UserInput.create(input, input);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            userInput.validate();
        });
    }

    @DisplayName("String이 Number가 아니면 IllegalException")
    @ParameterizedTest
    @CsvSource(value = {"k:1", "2:한", "한글:english"})
    void notNumberTest(String count, String time) {
        UserInput userInput = UserInput.create(count, time);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            userInput.validate();
        });
    }

}
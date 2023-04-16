package step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInputTest {

    @ParameterizedTest
    @CsvSource(value = {"-1:2", "2:-1", "-3:-8"}, delimiter = ':')
    void 값을_입력받을때_음수를_입력하면_예외를_던진다(int count, int retry) {
        assertThrows(
                IllegalArgumentException.class,
                () -> new UserInput(count, retry)
        );
    }

}
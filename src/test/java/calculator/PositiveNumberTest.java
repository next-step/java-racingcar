package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PositiveNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"-1,Is not positive number", "ㅁ,Is not number"})
    void generateErrorTest(String input, String errorMessage) {
        RuntimeException e = Assertions.assertThrows(RuntimeException.class, ()->new PositiveNumber(input));
        assertThat(e.getMessage()).isEqualTo(errorMessage);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "10,10"})
    void generateTest(String input, int expected) {
        assertThat(new PositiveNumber(input).valueOf())
                .isEqualTo(expected);
    }
}
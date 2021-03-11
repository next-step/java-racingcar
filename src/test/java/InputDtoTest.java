import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputDtoTest {

    @ParameterizedTest
    @CsvSource(value = {"'1':1", "'2':2"}, delimiter = ':')
    void toInteger(String input, int result) {
        assertThat(InputDto.toInteger(input))
                .isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"'':true", "' ':true", "'car':false"}, delimiter = ':')
    void isBlank(String input, boolean expected) {
        assertThat(InputDto.isBlank(input))
                .isEqualTo(expected);
    }
}
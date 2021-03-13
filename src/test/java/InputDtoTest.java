import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.InputDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class InputDtoTest {

    @ParameterizedTest
    @DisplayName("IllegalArgumentException 테스트")
    @CsvSource(value = {"' ':'1'", "'test':'a'"}, delimiter = ':')
    void toInteger(String input1, String input2) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new InputDto(input1, input2);
                });
    }
}
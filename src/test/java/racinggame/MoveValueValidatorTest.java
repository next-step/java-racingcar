package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoveValueValidatorTest {

    @DisplayName("전진 조건 판단")
    @ParameterizedTest
    @CsvSource(value = {
            "3 | false",
            "4 | true",
            "7 | true",
            "0 | false"
    }, delimiter = '|')
    void validateMoveValue(int value, boolean expected)  {
        assertThat(MoveValueValidator.validate(value)).isEqualTo(expected);
    }

}
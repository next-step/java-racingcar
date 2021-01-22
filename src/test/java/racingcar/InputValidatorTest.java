package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator inputValidator = new InputValidator();

    @Test
    void validateCarName() {
        String[] cars1 = {" ", " ", " "};
        assertThat(inputValidator.validateCarName(cars1)).isFalse();
        String[] cars2 = {"123456", "123", "112"};
        assertThat(inputValidator.validateCarName(cars2)).isFalse();
        String[] cars3 = {"12345", "123", "112"};
        assertThat(inputValidator.validateCarName(cars3)).isTrue();
    }

    @Test
    void validGameCntInput() {
        assertThat(inputValidator.validGameCntInput("123")).isTrue();
        assertThat(inputValidator.validGameCntInput("dgdsgsd")).isFalse();
        assertThat(inputValidator.validGameCntInput("")).isFalse();
    }
}
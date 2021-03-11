package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringValidationTest {

    @DisplayName("Exception 테스트, 자동차이름 5자 초과")
    @Test
    void validateCarNameSize() {
        String[] carNames = {"자동차A", "자동차BC", "자동차DEF"};

        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringValidation.validateCarNameSize(carNames);
        }).withMessage(RacingGameError.CAR_NAME_LENGTH_OVER);
    }
}

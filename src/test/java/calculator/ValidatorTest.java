package calculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 입력값이_Null일_때() {
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.stringCheck(null));
    }

    @Test
    void 입력값이_공백일_때() {
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.stringCheck(""));
    }

    @Test
    void 입력값에_사칙연산이_아닌_값이_있을_때() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> Validator.stringCheck("2 / 3 + 2 # 3"));
    }
}

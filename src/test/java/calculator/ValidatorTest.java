package calculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void 입력값이_Null일_때() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> validator.stringCheck(null));
    }

    @Test
    void 입력값이_공백일_때() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> validator.stringCheck(""));
    }

    @Test
    void 입력값에_사칙연산이_아닌_값이_있을_때() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> validator.stringCheck("2 / 3 + 2 # 3"));
    }
}
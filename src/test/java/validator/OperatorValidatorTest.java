package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorValidatorTest {

    OperatorValidator validator = new OperatorValidator();

    @Test
    @DisplayName("숫자가 와야하는 부분에 숫자가 아닌 문자가 올 경우 예외 발생 테스트")
    void numberErrorTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.check("* *"))
                .withMessage("number format is invalid");
    }

    @Test
    @DisplayName("연산자 부분에 연산자가 아닌 문자가 올 경우 예외 발생 테스트")
    void operatorErrorTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.check("1 1"))
                .withMessage("operator is invalid");
    }
}

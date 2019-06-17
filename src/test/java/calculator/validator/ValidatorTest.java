package calculator.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("입력값이 null 또는 공백으로만 이루어진 String 이라면 IllegalArgumentException 발생한다.")
    void validateInput() {

        List<String> invalidInputs = Arrays.asList(null, "", " ", "    ");

        invalidInputs.forEach(invalidInput ->
                                      assertThatIllegalArgumentException()
                                              .isThrownBy(() -> Validator.validateInput(invalidInput))
                                              .withMessage("입력값이 유효하지 않습니다."));

    }

    @Test
    @DisplayName("토큰의 개수는 3개 이상이고 홀수여야하며, 연산기호는 (+, -, *, /)만 허용된다.")
    void validateToken() {

        assertThatCode(() -> Validator.validateToken(Arrays.asList("2", "+", "3", "*", "4", "/", "2"))).doesNotThrowAnyException();
        assertThatCode(() -> Validator.validateToken(Arrays.asList("2", "+", "3"))).doesNotThrowAnyException();
        assertThatCode(() -> Validator.validateToken(Arrays.asList("3", "*", "4"))).doesNotThrowAnyException();
        assertThatCode(() -> Validator.validateToken(Arrays.asList("4", "/", "2"))).doesNotThrowAnyException();

        assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateToken(Arrays.asList("4", "/", "2", "+")))
                .withMessage("연산자의 개수가 유효하지 않습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateToken(Arrays.asList("4", "/")))
                .withMessage("연산자의 개수가 유효하지 않습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateToken(Arrays.asList("4")))
                .withMessage("연산자의 개수가 유효하지 않습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateToken(Collections.emptyList()))
                .withMessage("연산자의 개수가 유효하지 않습니다.");

        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> Validator.validateToken(Arrays.asList("4", ",", "3")));
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> Validator.validateToken(Arrays.asList("4", "3", "3")));
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> Validator.validateToken(Arrays.asList("4", "%", "3")));
    }

}
package calculator.domain;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @DisplayName("공백이 들어왔는지 확인")
    @Test
    void 공백() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> Validator.checkEmpty(""));

        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> Validator.checkEmpty("  "));
    }

    @DisplayName("숫자, 연산자, 공백 외 문자가 있는지 확인")
    @Test
    void 다른_문자() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> Validator.checkInputType("1+abg8-10"));

        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> Validator.checkInputType("123+5340 ^1123"));
    }

    @DisplayName("연산이 가능한 순서로 들어왔는지 확인")
    @Test
    void 숫자_연산자_순서() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> Validator.checkOrder(Arrays.asList("1", "+", "-")));

        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> Validator.checkOrder(Arrays.asList("1", "2", "*")));
    }
}
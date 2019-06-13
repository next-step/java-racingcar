package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class ValidatorTest {

    private Validator<String> validator;

    @BeforeEach
    void setUp() {
        validator = new ExpressionValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 - 2 + 3 * 4 / 1",
            "1  -  2  +  3  *  4  /  1",
            "1   -   2   +   3   *   4   /   1",
            "1 -  2   +    3     *      4       /        1",
            "1        -       2      +     3    *   4  /  1",
    })
    void 숫자_사이에_빈칸이_여러개인_경우는_올바른_수식(String input) {
        assertThatCode(() -> validator.validate(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 숫자_하나만_존재하는_경우는_올바른_수식() {
        final String expression = "1";
        assertThatCode(() -> validator.validate(expression))
                .doesNotThrowAnyException();
    }

    @Test
    void 입력값이_null_인_경우_IllegalArgumentException_을_던져야함() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(null));
    }

    @Test
    void 입력값이_빈_문자열인_경우_IllegalArgumentException_을_던져야함() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(""));
    }

    @Test
    void 숫자만_연속으로_나오는_경우는_올바른_수식이_아님() {
        final String expression = "1 2 + 3 + 4";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(expression));
    }

    @Test
    void 연산자만_연속으로_나오는_경우는_올바른_수식이_아님() {
        final String expression = "1 +  + 3 + 4";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(expression));
    }

    @Test
    void 연산자가_가장_먼저_나오는_경우는_올바른_수식이_아님() {
        final String expression = "+ 2 + 3 + 4";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(expression));
    }

    @Test
    void 숫자가_부호있는_정수인_경우는_올바른_수식이_아님() {
        final String expression = "1 + -2 + 3 + 4";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(expression));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 % 2 + 3 + 4",
            "1 ^ 2 + 3 + 4",
            "1 & 2 + 3 + 4",
            "1 = 2 + 3 + 4",
            "1 | 2 + 3 + 4",
            "1 ~ 2 + 3 + 4",
            "1 ! 2 + 3 + 4",
    })
    void 사칙연산_기호가_아닌_연산자가_나오는_경우_올바른_수식이_아님(String expression) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(expression));
    }
}

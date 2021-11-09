package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.Validation.VALID_NULL_EMPTY_CHECK_MSG;

public class MyNumberTest {

    @Test
    void create() {
        assertThat(new MyNumber(1)).isEqualTo(new MyNumber(1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 숫자_입력값이_Null_또는_빈공백(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new MyNumber(input);
        }).withMessageMatching(VALID_NULL_EMPTY_CHECK_MSG);
    }

}

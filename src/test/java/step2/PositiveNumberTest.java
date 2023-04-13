package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 양수_입력시_정상적으로_객체생성(int input) {
        assertThatCode(() -> new PositiveNumber(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void 음수_입력시_예외발생(int input) {
        assertThatThrownBy(() -> new PositiveNumber(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 숫자가_아닌_문자열_입력시_예외발생() {
        assertThatThrownBy(() -> new PositiveNumbers(
                new String[]{
                        "a",
                        "b",
                        "c"
                })
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 숫자가로_변환가능한_문자_입력시() {
        assertThatCode(() -> new PositiveNumbers(
                new String[]{
                        "1",
                        "2",
                        "3"
                })
        ).doesNotThrowAnyException();
    }
}

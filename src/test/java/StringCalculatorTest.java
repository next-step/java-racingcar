import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.StringCalculator.calculate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource({
        "'', 0",
        ", 0",
    })
    void 빈문자열과_널은_0으로_반환(String value, int expected) {
        assertThat(calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "'1,2', 3",
        "'1,2,3', 6",
        "'1,2,3,4', 10",
    })
    void 쉼표_구분자_사용하여_계산(String value, int expected) {
        assertThat(calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "'1:2', 3",
        "'1:2:3', 6",
        "'1:2:3:4', 10",
    })
    void 콜론_구분자_사용하여_계산(String value, int expected) {
        assertThat(calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "'//;\n1;2', 3",
        "'//;\n1;2;3', 6",
        "'//;\n1;2;3;4', 10",
    })
    void 커스텀_구분자_사용하여_계산(String value, int expected) {
        assertThat(calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "'1,2:3', 6",
        "'//;\n1,2:3;4', 10",
    })
    void 여러_구분자_사용하여_계산(String value, int expected) {
        assertThat(calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "가", "A", " ", "-1", "가,1", "A,1", " ,1", "-1,1"
    })
    void 숫자_이외의_값_또는_음수는_RuntimeException_예외_발생(String value) {
        assertThatThrownBy(() -> calculate(value))
            .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "//\n1;2", "//1\n1;2;3", "//-1\n1;2;3;4", "//1\n11111", "//1\n21314"
    })
    void 커스텀_구분자가_없거나_숫자일_경우_RuntimeException_예외_발생(String value) {
        assertThatThrownBy(() -> calculate(value))
            .isInstanceOf(RuntimeException.class);
    }
}

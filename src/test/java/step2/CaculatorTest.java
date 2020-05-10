package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CaculatorTest {

    @DisplayName("입력한 계산식 사이의 공백문자는 무시된다")
    @CsvSource(value = {
            "2 + 3 * 4 / 2, 10",
            "2 +3*4/2, 10",
            "2 +3*4 / 2, 10",
            "2+3*4/2, 10"})
    @ParameterizedTest
    public void whiteSpaceIgnoreTest(String input, int result) {
        assertThat(Caculator.caculate(input)).isEqualTo(result);
    }

    @DisplayName("계산식이 올바르면 결과 값을 숫자로 반환한다")
    @CsvSource(value = {
            "2 + 3 * 4 / 2, 10",
            "2 / 3 + 4 * 2, 8",
            "2 * 3 / 4 + 2, 3"})
    @ParameterizedTest
    public void valideCaculationTest(String input, int result) {
        assertThat(Caculator.caculate(input)).isEqualTo(result);
    }

    @DisplayName("계산식이 올바르지 않으면 IllegalArgumentException 예외를 발생시킨다")
    @ValueSource(strings = {
            " ",
            "2",
            "+",
            "2+2+",
            "+2+2",
            "2+2+2-"})
    @ParameterizedTest
    public void inavalidCaculationTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Caculator.caculate(input);
        });
    }
}

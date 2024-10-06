package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    private final StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈문자를 입력할 경우 0을 반환한다.")
    public void splitAndSum_null_또는_빈문자(String input) {
        assertThat(stringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 입력할 경우 해당 숫자를 반환한다.")
    public void splitAndSum_숫자하나() throws Exception {
        int result = stringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 해당 숫자들에 합을 반환한다.")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자에 컴마 또는 콜론 구분자로 입력할 경우 해당 숫자들에 합을 반환한다.")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("'//'와 '\\n' 사이에 커스텀 구분자를 지정하면 해당 구분자로 분리한 숫자의 합을 반환한다")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3","A,2,3"})
    @DisplayName("숫자 이외의 값 또는 음수를 전달할 경우 RuntimeException을 throw한다")
    public void splitAndSum_negative(String input) throws Exception {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }
}
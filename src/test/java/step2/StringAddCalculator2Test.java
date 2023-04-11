package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.study.StringAddCalculator2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringAddCalculator2Test {
    @ParameterizedTest
    @NullAndEmptySource
    public void checkNullOrEmpty_ReturnZero(String input) {
        int result = StringAddCalculator2.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("구분자로 text 구분")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    public void separateWithCharacter_ReturnStringArray(String input) throws Exception{
        int result = StringAddCalculator2.splitAndSum(input);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자가 아닌 문자열과 음수를 integer타입으로 형변환 했을 때 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"ee,2:3", "-1,2,3"})
    public void convertStringToInt(String input) throws Exception{
        assertThatThrownBy(() -> StringAddCalculator2.splitAndSum(input))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("사용자 지정 구분자 사용")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    public void splitTextWithCustomDelimiter(String input) throws Exception{
        int result = StringAddCalculator2.splitAndSum(input);
        assertThat(result).isEqualTo(6);
    }
}

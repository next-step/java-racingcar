package racingcar.step2;

import com.nextstep.utils.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.nextstep.utils.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringAddCalculatorTest {

    @Test
    @DisplayName("빈문자열 또는 null 값을 입력할 경우 0을 반환한다")
    void splitAndSum_null_or_emptyText() {
        int result = splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest(name = "[{index}] {0} 의 정수 결과는 {0} 이다")
    @ValueSource(strings = {"1","2","3"})
    public void splitAndSum_single_number_str(String valueSource) {
        int result = splitAndSum(valueSource);
        assertThat(result).isEqualTo(Integer.parseInt(valueSource));
    }

    @Test
    @DisplayName("쉼표 구분자 입력 두 숫자의 합을 반환한다")
    public void splitAndSum_with_comma() throws Exception {
        int result = splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 구분자, 콜론 구분자 복합 입력일 경우 숫자의 합을 반환한다")
    public void splitAndSum_comma_or_colon_complex_separator() throws Exception {
        int result = splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정하였을 경우 숫자의 합을 반환한다")
    public void splitAndSum_custom_separator() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}
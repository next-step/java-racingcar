import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 덧셈 계산기 테스트")
public class StringAddCalculatorTest {

    @DisplayName("널 또는 빈 문자열을 입력하면 0을 반환한다.")
    @Test
    void splitAndSum_null_or_emptyString() throws Exception {
        int result = StringAddCalculator.splitAndSum(null);
        Assertions.assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        Assertions.assertThat(result).isEqualTo(0);
    }

    @DisplayName("문자 하나를 입력하면 int 형 문자를 반환한다.")
    @Test
    void splitAndSum_oneNumber() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        Assertions.assertThat(result).isEqualTo(1);
    }

    @DisplayName("콤마를 기준으로 문자열을 분리한 후 문자를 더한다.")
    @Test
    void splitAndSum_number_by_comma() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @DisplayName(",와:를 기준으로 문자열을 분리한 후 문자를 더한다.")
    @Test
    void splitAndSum_number_by_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자를 기준으로 문자열을 분리한 후 문자를 더한다.")
    @Test
    void splitAndSum_number_by_추가_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @DisplayName("입력 값에 음수가 있을 경우 예외가 발생한다.")
    @Test
    void splitAndSum_negative() {
        Assertions.assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
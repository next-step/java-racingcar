import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class UtilTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("input값이 null 혹은 빈문자열인지 확인 테스트")
    public void isNullOrBlankTest(String input) {
        assertThat(Util.isNullOrBlank(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2","3,3"})
    @DisplayName("숫자 변환 테스트")
    public void convertInputTest(String input, int result) {
        assertThat(Util.convertInput(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1:2:3", "1,2,3"})
    @DisplayName("split 테스트")
    public void splitTest(String str) {
        assertThat(Util.split(str).length).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//:\n1:2:3"})
    @DisplayName("//와 \n 문자사이에 커스텀 구분자가 있는지 판별 후 boolean 반환")
    public void hasCustomDelimiterTest(String input) {
        assertThat(Util.hasCustomDelimiter(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2,3"})
    @DisplayName("음수가 있는지 확인 테스트")
    public void hasMinusNumberTest(String input) {
        String[] nums = Util.split(input);
        assertThatThrownBy(() -> Util.hasMinusNumber(nums)).isInstanceOf(RuntimeException.class);
    }
}

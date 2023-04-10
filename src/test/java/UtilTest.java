import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("input값이 null 혹은 빈문자열인지 확인하는 메소드")
    public void isNullOrBlankTest(String input) {
        assertThat(Util.isNullOrBlank(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2","3,3"})
    public void convertInputTest(String input, int result) {
        assertThat(Util.convertInput(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1:2:3", "1,2,3"})
    @DisplayName("split 테스트")
    public void splitTest(String str) {
        assertThat(Util.split(str, ",|:").length).isEqualTo(3);
    }
}

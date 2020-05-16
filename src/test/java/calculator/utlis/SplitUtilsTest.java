package calculator.utlis;

import calculator.utils.SplitUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("SplitUtils 클래스 테스트")
public class SplitUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("공백 문자열 split 테스트")
    void splitEmptyStringTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            SplitUtils.split(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:7", "2 + 3 * 4 / 2 - 1:9"}, delimiter = ':')
    @DisplayName("올바른 split 테스트")
    void splitTest(String input, int expected) {
        assertThat(SplitUtils.split(input).length).isEqualTo(expected);
    }
}

package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {

    @DisplayName("입력받은 문자열이 null이거나 empty 여부를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void isNullOrEmpty(String input) {
        assertTrue(StringUtils.isNullOrEmpty(input));
    }

    @Test
    @DisplayName("String을 Integer로 변환한다.")
    void parseStringToInt() {
        assertThat(StringUtils.parseStringToInt("5")).isEqualTo(5);
    }
}

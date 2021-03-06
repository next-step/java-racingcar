package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringUtilTest {

    @DisplayName("입력 문자열이 공백값을 기준으로 배열로 변환된다")
    @Test
    public void splitBySpace_ShouldReturnArray() {
        StringUtil stringUtil = new StringUtil("10 + 15 - 7 * 3 / 9");

        assertThat(stringUtil.splitBySpace()).containsExactly("10", "+", "15", "-", "7", "*", "3", "/", "9");
    }

    @DisplayName("입력 문자열 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 를 던진다")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    public void splitBySpace_ShouldThrowIllegalArgumentExceptionForNullAndEmptyStrings(String inputString) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new StringUtil(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

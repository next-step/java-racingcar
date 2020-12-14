package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {
    @Test
    @DisplayName("입력받은 문자열이 null이거나 empty 여부를 반환한다.")
    void isNullOrEmpty() {
        assertThat(Utils.isNullOrEmpty(" ")).isTrue();
        assertThat(Utils.isNullOrEmpty("")).isTrue();
        assertThat(Utils.isNullOrEmpty(null)).isTrue();
        assertThat(Utils.isNullOrEmpty("not null")).isFalse();
    }

    @Test
    @DisplayName("String을 Integer로 변환한다.")
    void parseStringToInt() {
        assertThat(Utils.parseStringToInt("5")).isEqualTo(5);
    }
}

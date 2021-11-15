package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName("숫자 문자열을 split")
    public void split() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("괄호씌인 숫자 문자열을 substring")
    public void subString() {
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 charAt()을 이용해 특정 위치의 문자를 가져온다")
    public void charAt() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                "abc".charAt(3);
            }).withMessageMatching("String index out of range: " + 3);
    }

}
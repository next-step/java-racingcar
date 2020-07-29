package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class _01_StringTest {
    @DisplayName("요구사항1-split")
    @Test
    void split() {
        assertThat("1,2".split(",")).contains("1");
        assertThat("1".split(",")).containsExactly("1");
    }

    @DisplayName("요구사항2-substring")
    @Test
    void substring() {
        String data = "(1,2)";
        // beginIndex는 index 포함해서 시작하기 때문에 "(" 다음 문자를 지정하기 위해 + 1 처리
        int beginIndex = data.indexOf("(") + 1;
        int endIndex = data.indexOf(")");
        assertThat(beginIndex).isEqualTo(1);
        assertThat(endIndex).isEqualTo(4);
        assertThat(data.substring(beginIndex, endIndex)).isEqualTo("1,2");
    }

    @DisplayName("요구사항3-charAt")
    @Test
    void charAt() {
        final String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');

        final int overIndex = data.length() + 1;
        String message = "String index out of range: " + overIndex;
        assertThatThrownBy(()->data.charAt(overIndex))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessage(message)
        ;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(()->data.charAt(overIndex))
            .withMessage(message)
        ;
    }
}

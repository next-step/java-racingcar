package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        Assertions.assertThat("1,2".split(",")).containsExactly("1", "2");
        Assertions.assertThat("1".split(",")).contains("1");
    }

    @Test
    void subString() {
        Assertions.assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String CharAt 메소드 및 인덱스값이 벗어날 경우 StringIndexOutOfBoundsException 처리 테스트")
    void charAtAndBoundsException() {
        Assertions.assertThat("abc".charAt(0)).isEqualTo('a');
        Assertions.assertThat("abc".charAt(1)).isEqualTo('b');
        Assertions.assertThat("abc".charAt(2)).isEqualTo('c');
        Assertions.assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("String 클래스의 split 메소드에 대해 테스트한다.")
    void split() {
        assertThat("1,2".split(",")).contains("1", "2");
    }

    @Test
    @DisplayName("String 클래스의 split 메소드에 대해 테스트한다. 구분자가 없는 문자열 입력에 대해서 테스트 한다.")
    void splitOnSingleValue() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("String 클래스의 substring 메소드에 대해 테스트한다.")
    void substring() {
        String value = "(1,2)";
        assertThat(value.substring(1, value.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 클래스의 charAt 메소드에 대해 테스트한다.")
    void charAt() {
        String value = "abc";

        assertThat(value.charAt(0)).isEqualTo('a');

        assertThatThrownBy(() -> {
            value.charAt(value.length() + 1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

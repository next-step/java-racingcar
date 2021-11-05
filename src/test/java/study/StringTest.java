package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("\"1,2\" split 테스트")
    void splitTest1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\" split 테스트")
    void splitTest2() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("\"(1,2)\"에서 substring() 메소드로 ()를 제거하는 테스트")
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드 테스트")
    void charAtTest1() {
        String string = "abc";
        assertThat(string.charAt(0)).isEqualTo('a');
        assertThat(string.charAt(1)).isEqualTo('b');
        assertThat(string.charAt(2)).isEqualTo('c');
    }

    @ParameterizedTest
    @DisplayName("charAt() 메소드 StringIndexOutOfBoundsException 테스트")
    @ValueSource(ints = {-1, 3})
    void charAtTest2(int index) {
        String string = "abc";

        assertThatThrownBy(() -> string.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: " + index);
    }
}

package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    // 요구사항 1
    @Test
    void splitTest1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitTest2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    // 요구사항 2
    @Test
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    // 요구사항 3
    @ParameterizedTest
    @DisplayName("특정 위치의 문자를 가져오는지 확인")
    @CsvSource(value = {"a:0", "b:1", "c:2"}, delimiter = ':')
    void charAtTest(char input, int expected) {
        assertThat(input).isEqualTo("abc".charAt(expected));
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutBoundsException 발생")
    void charAtExceptionTest() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("out of range: 3");
    }
}

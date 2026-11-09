package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIndexOutOfBoundsException;

public class StringClassTest {

    @DisplayName("String.split(): (1) 특정 문자를 구분자로 하여 문자열 배열을 생성한다.")
    @Test
    void string_split_function_1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("String.split(): (2) 특정 문자를 구분자로 하여 문자열 배열을 생성한다.")
    @Test
    void string_split_function_2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("String.substring(): 특정문자들을 제거하여 문자열을 생성한다.")
    @Test
    void spring_substring_function_1() {
        String example = "(1,2)";
        String result = example.substring(1, example.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("String.charAt(): 지정한 인덱스의 문자를 반환한다")
    @Test
    void string_charAt_function_1() {
        char result = "abc".charAt(0);
        assertThat(result)
                .isEqualTo('a');
    }

    @DisplayName("String.charAt(): 위치 값을 벗어나면 IndexOutOfBoundsException이 발생한다.")
    @Test
    void string_charAt_with_IndexOutOfBoundsException() {
        String example = "abc";
        assertThatIndexOutOfBoundsException()
                .isThrownBy(() -> example.charAt(5))
                .withMessageMatching("Index \\d+ out of bounds.*")
                .withMessageContaining("Index 5 out of bounds");
    }

}

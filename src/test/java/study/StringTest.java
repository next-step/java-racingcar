package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("두 숫자를 ,로 분리한다")
    @Test
    void splitTwoNumbers() {

        String numbers = "1,2";
        String[] result = numbers.split(",");
        assertThat(result).contains("1", "2");
    }

    @DisplayName("한 숫자를 ,로 분리하여도 그대로이다")
    @Test
    void splitSingleNumber() {

        String number = "1";
        String[] result = number.split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("substring을 사용해 ()를 제거한다")
    @Test
    void splitWithSubstring(){

        String expression = "(1,2)";
        String result = expression.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 문자의 위치를 찾을 수 있다")
    @Test
    void findLetterC(){

        String letters = "abc";
        char result = letters.charAt(2);
        assertThat(result).isEqualTo('c');
    }

    @DisplayName("특정 위치의 문자를 가져올때 위치 값을 벗어나면 예외를 발생시킨다")
    @Test
    void testException(){

        String letters = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> letters.charAt(10));
    }

}

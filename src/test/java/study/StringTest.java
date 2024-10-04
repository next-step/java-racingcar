package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @Test
    void split_ShouldReturnSplitValues() {
        String target = "1,2";
        String[] result = target.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_ShouldReturnSplitValue() {
        String target = "1";
        String[] result = target.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    void substring_ShouldReturnSubstring() {
        String target = "(1,2)";
        String result = target.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_ShouldReturnSpecifiedChar() {
        String target = "abc";
        char[] expectedResult = {'a', 'b', 'c'};

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            assertThat(c).isEqualTo(expectedResult[i]);
        }
    }

    @Test
    @DisplayName("charAt 으로 length 이상의 인덱스의 char 를 추출하려고 하면 예외를 발생시킨다.")
    void charAt_ShouldThrowStringIndexOutOfBoundsException() {
        String target = "abc";

        Random random = new Random();
        int invalidIndex = random.nextInt(Integer.MAX_VALUE) + target.length();

        assertThatThrownBy(() -> {
            target.charAt(invalidIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: " + invalidIndex);
    }
}

package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @Nested
    class requirements1 {
        @Test
        void splitString1() {
            String input = "1,2";
            String[] result = input.split(",");
            assertThat(result).containsExactly("1", "2");
        }

        @Test
        void splitString2() {
            String input = "1";
            String[] result = input.split(",");
            assertThat(result).containsExactly("1");
        }
    }

    @Nested
    class requirements2 {
        @Test
        void substringString() {
            String input = "(1,2)";
            String result = input.substring(1, input.length() - 1);
            assertThat(result).isEqualTo("1,2");
        }
    }

    @Nested
    class requirements3 {
        @Test
        @DisplayName("문자열 \"abc\"에서 범위를 벗어난 인덱스의 문자를 요청하면 예외가 발생한다")
        void charAtString() {
            String input = "abc";
            int index = 10;
            assertThrows(StringIndexOutOfBoundsException.class, () -> {
                input.charAt(index);
            }, "인덱스 " + index + " 은 문자열의 길이를 벗어나므로 예외가 발생해야 한다");
        }
    }

}

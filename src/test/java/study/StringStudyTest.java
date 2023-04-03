package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringStudyTest {

    @Test
    void splitTest() {
        String commaString = "1,2";

        String[] result = commaString.split(",");

        assertThat(result.length).isEqualTo(2);
        assertThat(result).containsExactly("1", "2");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
    }

    @Test
    void substringTest() {
        int position = 1;
        String parentheses = "(1,2)";

        String result = parentheses.substring(position, parentheses.length()-position);

        assertThat(result).isEqualTo("1,2");
    }
<<<<<<< HEAD

    @Test
    @DisplayName("특정 위치의 문자 확인 테스트")
    void charAtTest() {
        String testString = "abc";

        char a = testString.charAt(0);
        char b = testString.charAt(1);
        char c = testString.charAt(2);

        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("인덱스에서 벗어날 시 에러 반환 테스트")
    void charAtErrorTest() {
        String testString = "abc";

        assertThrows(StringIndexOutOfBoundsException.class,
                () -> testString.charAt(testString.length()));
    }
=======
>>>>>>> 33bd5ad (test - substring으로 () 제거 테스트)
}
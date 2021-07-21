package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("요구사항1 - split 테스트")
    void splitTest() {
        //given
        String str1 = "1,2";
        String str2 = "1";

        //when
        String[] splitResult1 = str1.split(",");
        String[] splitResult2 = str2.split(",");

        //then
        assertThat(splitResult1).contains("1").contains("2");
        assertThat(splitResult2).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 - substring 테스트")
    void substringTest() {
        //given
        String str = "(1,2)";

        //when
        String substringResult = str.substring(1, str.length() - 1);

        //then
        assertThat(substringResult).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 - charAt 테스트")
    void charAtTest() {
        //given
        String str = "abc";

        //when
        char charAtResult1 = str.charAt(0);
        char charAtResult2 = str.charAt(1);
        char charAtResult3 = str.charAt(2);

        //then
        assertThat(charAtResult1).isEqualTo('a');
        assertThat(charAtResult2).isEqualTo('b');
        assertThat(charAtResult3).isEqualTo('c');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(3);
                });
    }
}

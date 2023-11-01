import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


public class StringTest {
    @Test
    void splitTest1() {
        String str = "1,2";
        String[] splitString = str.split(",");
        assertThat(splitString).contains("1");
        assertThat(splitString).contains("2");
    }

    @Test
    void splitTest2() {
        String str = "1";
        String[] splitString = str.split(",");
        assertThat(splitString).containsExactly("1");
    }

    @Test
    void substringTest() {
        String str = "(1,2)";
        String substring = str.substring(1, str.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자가져오기")
    void charAtTest() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나는 경우")
    void charAtOutOfBoundTest() {
        String str = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(4);
                }).withMessageMatching("String index out of range: \\d+");
    }
}

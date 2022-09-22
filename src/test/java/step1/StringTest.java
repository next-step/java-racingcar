package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @Test
    void split() {
        //given
        String str1 = "1,2";
        String str2 = "1";

        //when
        String[] strArr1 = str1.split(",");
        String[] strArr2 = str2.split(",");

        //then
        assertThat(strArr1).contains("1","2");
        assertThat(strArr2).containsExactly("1");
    }

    @Test
    void substring() {
        //given
        String str = "(1,2)";

        //when
        String result = str.substring(1,4);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("")
    void charAt() {
        //given
        String str = "abc";

        //when
        char c = str.charAt(2);

        //then
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("assertThatExceptionOfType 사용한 Exception 처리")
    void charAtException() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c2 = "abc".charAt(3);
                    assertThat(c2).isEqualTo('c');
                }).withMessageMatching("index out of range: [0-9]");
    }
}

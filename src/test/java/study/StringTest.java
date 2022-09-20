package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void splitString() {
        String [] result = "1,2".split(",");
        Assertions.assertThat(result).containsExactly("1","2");
    }

    @Test
    void subStringTest() {
        String result2 = "(1,2)";
        result2 = result2.substring(1,4);
        Assertions.assertThat(result2).isEqualTo("1,2");
    }

    @Test
    @DisplayName("잘못된 인덱스 테스트")
    void charAtTest() {
        String result3 = "abc";
        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->{
                        char stringToChar = result3.charAt(3);
                        }
                );

    }
}

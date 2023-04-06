package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitTest() {
        String str = "1,2";
        String[] splitData = str.split(",");
        Assertions.assertThat(splitData).containsExactly("1", "2");
    }

    @Test
    void stripTest() {
        String str = "(1,2)";
        Assertions.assertThat(str.substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정한 위치의 문자를 가져오는 기능 테스트")
    void charAtTest() {
        String str = "abc";
        for(int i=0; i < str.length(); i++) {
            Assertions.assertThat(str.charAt(i)).isNotNull();
        }

        int outOfBoundIndex = str.length() + 1;
        Assertions.assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(outOfBoundIndex);
                }).withMessageMatching("String index out of range: \\d+");
    }
}



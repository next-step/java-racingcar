package study.step1;


import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringClassTest {

    @Order(1)
    @DisplayName("1) 문자열 분리 테스트")
    @Test
    void splitTest() {
        String string1 = "1,2";

        String[] split1 = string1.split(",", 2);
        assertThat(split1).contains("1");
        assertThat(split1).contains("2");
        assertThat(split1).containsExactly("1", "2");
        assertThat(split1).hasSize(2);

        String string2 = "1";

        String[] split2 = string2.split(",", 2);
        assertThat(split2).containsExactly("1");
        assertThat(split2).hasSize(1);
    }

    @Order(2)
    @DisplayName("2) 문자열 자르기 테스트")
    @Test
    void substringTest() {
        String string = "(1,2)";

        String substring = string.substring(1, string.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Order(3)
    @DisplayName("3) 문자열에서 특정 문자 가져오기 테스트")
    @Test
    void charAtTest() {
        String string = "abc";

        char c = string.charAt(1);
        assertThat(c).isEqualTo('b');

        int testValue = string.length() + 1;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c2 = string.charAt(testValue);
                }).withMessageContaining("String index out of range: " + testValue);
    }
}

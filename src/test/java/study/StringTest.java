package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class StringTest {

    @Test
    void split() {

        String[] requirement1 = "1,2".split(",");
        assertThat(requirement1).containsExactly("1", "2"); // containsExactly: 순서 포함 일치

        requirement1 = "1".split(",");
        assertThat(requirement1).contains("1");
    }

    @Test
    void isEqualTo() {
        String requirement2 = "(1,2)".substring(1, 4);
        assertThat(requirement2).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String.charAt을 활용하여 특정 위치의 문자를 가져오는 테스트")
    void charAt() {
        char abc = "abc".charAt(1);

        assertThat(abc).isEqualTo('b');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(3);
                }).withMessageMatching("String index out of range: \\d+");

    }

}

package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("요구사항 1(split 메소드 테스트)")
    void split() {
        String str = "1,2";
        String[] split = str.split(",");

        Assertions.assertThat(split).contains("1");
        Assertions.assertThat(split).contains("2");

        Assertions.assertThat(split).containsExactly("1","2");
    }

    @Test
    @DisplayName("요구사항 2(substring 메소드 테스트)")
    void substring() {
        String str = "(1,2)";
        str = str.substring(1,4);

        Assertions.assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3(charAt 메소드 테스트)")
    void charAt() {
        String str = "abc";

        Assertions.assertThat(str.charAt(0)).isEqualTo('a');
        Assertions.assertThat(str.charAt(1)).isEqualTo('b');
        Assertions.assertThat(str.charAt(2)).isEqualTo('c');

        Assertions.assertThat(str.charAt(0)).isNotEqualTo('b');

        Assertions.assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()-> {
                    str.charAt(100);
                }).withMessageMatching("String index out of range: \\d+");
    }
}

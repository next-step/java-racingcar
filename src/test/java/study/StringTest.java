package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Nested
    @DisplayName("요구사항 1")
    class Requirement1 {

        @Test
        @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
        void split() {
            String[] result = "1,2".split(",");
            assertThat(result).contains("1");
            assertThat(result).containsExactly("1", "2");
        }

        @Test
        @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
        void split2() {
            String[] result = "1".split(",");
            assertThat(result).contains("1");
            assertThat(result).containsExactly("1");
        }
    }

    @Nested
    @DisplayName("요구사항 2")
    class Requirement2 {

        @Test
        @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하도록 구현")
        void substring() {
            String result = "(1,2)".substring(1, 4);
            assertThat(result).isEqualTo("1,2");
        }
    }

    @Nested
    @DisplayName("요구사항 3")
    class Requirement3 {

        @Test
        @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
        void charAt() {
            String str = "abc";
            assertThat(str.charAt(0)).isEqualTo('a');
            assertThat(str.charAt(1)).isEqualTo('b');
            assertThat(str.charAt(2)).isEqualTo('c');
        }

        @Test
        @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
        void charAt2() {
            String str = "abc";
            assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(3);
                }).withMessageMatching("String index out of range: 3");

            assertThatThrownBy(() -> {
                str.charAt(3);
            }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
        }
    }
}

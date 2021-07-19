package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    void requirement1_1() {
        final String given = "1,2";
        final String[] actual = given.split(",");

        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void requirement1_2() {
        final String given = "1";
        final String[] actual = given.split(",");

        assertThat(actual).contains("1");
    }

    @Test
    void requirement2() {
        final String given = "(1,2)";
        final String actual = given.substring(1, given.length() - 1);

        assertThat(actual).isEqualTo("1,2");
    }

    @Nested
    @DisplayName("문자열의 특정 위치 문자를 가져올때")
    class when_string_charAt {
        @Test
        void requirement3_1() {
            final String actual = "abc";

            assertThat(actual.charAt(0)).isEqualTo('a');
        }

        @DisplayName("위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다.")
        @Test
        void requirement3_2() {
            assertThatThrownBy(() -> "abc".charAt(3))
                    .isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: 3");
        }
    }
}

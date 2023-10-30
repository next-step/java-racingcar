package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class StringTest {

    @Test
    @DisplayName("split() 메소드를 테스트한다.")
    void split() {
        // given
        String data = "1,2";

        // when
        String[] split = data.split(",");

        // then
        assertAll(
                () -> assertThat(split).contains("1"),
                () -> assertThat(split).contains("2"),
                () -> assertThat(split).containsExactly("1", "2")
        );
    }

    @Test
    @DisplayName("substring() 메서드를 테스트한다.")
    void substring() {
        // given
        String data = "(1,2)";

        // when
        String substring = data.substring(1, data.length() - 1);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메서드를 테스트한다.")
    void charAt() {
        // given
        String data = "abc";

        // when

        // then
        assertAll(
                () -> assertThat(data.charAt(0)).isEqualTo('a'),
                () -> assertThat(data.charAt(1)).isEqualTo('b'),
                () -> assertThat(data.charAt(2)).isEqualTo('c'),
                () -> assertThatThrownBy(() -> data.charAt(3))
                        .isInstanceOf(IndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range: 3")
        );
    }
}

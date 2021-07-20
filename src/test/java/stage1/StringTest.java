package stage1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("요구사항 1-1")
    void split_1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 1-2")
    void split_2() {
        String[] actual = "1".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
        assertThat(actual).contains("1,2");
    }

    @Test
    @DisplayName("요구사항 3-1")
    void charAt_1() {
        String actual = "abc";
        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("요구사항 3-2")
    void charAt_2() {
        assertThatThrownBy(()-> "abc".charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }
}

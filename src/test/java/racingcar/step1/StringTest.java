package racingcar.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created : 2020-10-28 오전 10:05
 * Developer : Seo
 */
class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)";
        assertThat(result.substring(1, result.lastIndexOf(")"))).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String result = "abc";
        assertThat(result.charAt(0)).isEqualTo('a');
        assertThat(result.charAt(1)).isEqualTo('b');
        assertThat(result.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("Exception Test With DisplayName")
    void givenOutOfIndex_thenThrowException() {
        String result = "abc";
        assertThatThrownBy(() -> result.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}

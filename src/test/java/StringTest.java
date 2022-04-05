import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @DisplayName("요구사항1 - split 테스트")
    @Test
    void testSplit() {
        String value = "1,2";
        String[] split = value.split(",");
        assertThat(split).hasSize(2);
        assertThat(split).contains("1", "2");
        assertThat(split).containsExactly("1", "2");

        String value2 = "1";
        String[] split2 = value2.split(",");
        assertThat(split2).hasSize(1);
        assertThat(split2).contains("1");
        assertThat(split).containsExactly("1");
    }

    @DisplayName("요구사항2 - substring 테스트")
    @Test
    void testSubstring() {
        String value = "(1,2)";
        String substring = value.substring(1, value.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("요구사항3 - charAt 테스트")
    @Test
    void testCharAt() {
        String value = "abc";
        char charAt = value.charAt(0);
        assertThat(charAt).isEqualTo('a');

        assertThatThrownBy(() -> value.charAt(value.length())).isInstanceOf(StringIndexOutOfBoundsException.class)
                                                              .hasMessageContaining("String index out of range");
    }

}

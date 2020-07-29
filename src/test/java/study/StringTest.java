package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("String split 분리 테스트")
    void splitTest() {
        String[] strArr = "1,2".split(",");

        assertThat(strArr).contains("1", "2");
        assertThat(strArr).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String substring 테스트")
    void subStringTest() {
        String str = "(1,2)".substring(1,4);
        assertThat(str).isEqualTo("1,2");
        assertThat(str).hasSize(3);
    }

    @Test
    @DisplayName("charAt 테스트")
    void charAtTest() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

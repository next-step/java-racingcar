package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split 테스트")
    void splitTest() {
        final String[] testValue = "1,2".split(",");
        final String[] testValue2 = "1".split(",");
        assertThat(testValue).contains("1", "2");
        assertThat(testValue[0]).isEqualTo("1");
        assertThat(testValue2).containsExactly("1");
    }

    @Test
    @DisplayName("replace 테스트")
    void replaceTest() {
        final String test = "(1,(2)".replace("(", "").
                replace(")", "");
        assertThat(test).isEqualTo("1,2");
        assertThat(test).contains("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 테스트")
    void stringIndexOutOfBoundsExceptionTest() {
        final String test = "abc";
        assertThatThrownBy(() -> {
                test.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
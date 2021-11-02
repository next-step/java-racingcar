package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CharAtTest {

    @Test
    @DisplayName("assertThatThrownBy")
    void charAtException() {

        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    @Test
    @DisplayName("assertThatExceptionOfType")
    void charAtExceptionOfType() {

        int n = 3;
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> { "abc".charAt(n); })
                .withMessageMatching("String index out of range: \\d+");
    }
}

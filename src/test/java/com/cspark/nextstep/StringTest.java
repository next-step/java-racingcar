package com.cspark.nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    private final String COMMA_DELIMITER = ",";

    @DisplayName("요구사항 1")
    @Test
    void split() {
        String[] strings = "1,2".split(COMMA_DELIMITER);
        assertThat(strings).contains("1");
        assertThat(strings).contains("2");
        assertThat(strings).containsExactly("1", "2");

        String[] ones = "1".split(COMMA_DELIMITER);
        assertThat(ones).contains("1");
    }

    @DisplayName("요구사항 2")
    @Test
    void substring() {
        String context = "(1,2)".substring(1, 4);
        assertThat(context).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3")
    @Test
    void charAt() {
        assertThatThrownBy(() -> "abc".charAt(3))
        .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

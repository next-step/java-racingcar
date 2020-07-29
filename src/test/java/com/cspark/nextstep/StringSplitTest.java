package com.cspark.nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringSplitTest {

    @DisplayName("요구사항 1")
    @Test
    void split() {
        String[] strings = "1,2".split(",");
        assertThat(strings).contains("1");
        assertThat(strings).contains("2");
        assertThat(strings).containsExactly("1", "2");
    }

    @DisplayName("요구사항 3")
    @Test
    void charAt() {
        assertThatThrownBy(() -> "abc".charAt(3))
        .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

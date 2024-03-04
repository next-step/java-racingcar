package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilsTest {


    @Test
    void step2_mission_test() {
        // Given
        String test = "(1,2)";
        String expected = "1,2";
        // When
        String actual = StringUtils.removeParentheses(test);
        // Then
        assertThat(actual).isEqualTo(expected);
    }
}
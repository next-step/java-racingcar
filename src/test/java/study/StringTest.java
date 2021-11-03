package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("문자열 자르기")
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("split하여 1만 포함하는 배열을 반환한다.")
    void splitOnlyOne() {
        String[] result = "1".split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("괄호를 제거하고 1,2 반환한다.")
    void substring() {
        String str = "(1,2)";
        String result = str.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 범위를 벗어나는 값을 찾을 경우 예외를 던진다.")
    void charAtWithInvalidRange() {
        String str = "abc";

        assertThatThrownBy(() -> {
            str.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("4");
    }

    @Test
    @DisplayName("문자열의 정상 범위 안의 값을 확인한다.")
    void charAtWithValidRange() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(2)).isEqualTo('c');
        assertThat(str.length()).isEqualTo(3);
    }
}


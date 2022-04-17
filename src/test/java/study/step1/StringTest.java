package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 1")
    void split() {
        assertThat("1,2".split(",")).containsExactly("1","2");
        assertThat("1".charAt(0)).toString().contains("1");
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 2")
    void substring() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "abcdefg"})
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 3")
    void charAt(String input) {
        assertThatThrownBy(() -> {input.charAt(5);})
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}

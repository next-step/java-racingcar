package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 3")
    void charAt() {
        assertThatThrownBy(() -> { "a,b,c".charAt(10); })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("boom");
    }
}

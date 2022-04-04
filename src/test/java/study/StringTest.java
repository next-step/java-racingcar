package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 1")
    void split() {
        String[] splitValue1 = "1,2".split(",");
        assertThat(splitValue1).containsExactly("1","2");

        String[] splitValue2 = "1".split(",");
        assertThat(splitValue2).contains("1");
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 2")
    String substring() {
        String substringValue = "(1,2)".substring(1, 4);
        assertThat(substringValue).isEqualTo("1,2");
        return substringValue;
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 3")
    void charAt() {
        assertThatThrownBy(() -> { "a,b,c".charAt(10); })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("boom");
    }
}

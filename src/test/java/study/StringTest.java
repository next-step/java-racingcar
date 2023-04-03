package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항1")
    @Test
    void string_split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");

        result = "1".split(",");
        assertThat(result).contains("1");
    }

    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항2")
    @Test
    void string_substring() {
        String text = "(1,2)";
        String textSubstring = text.substring(1, text.length() -1);

        assertThat(textSubstring).isEqualTo("1,2");
    }

    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항3")
    @Test
    void string_chatAt() {

        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");

        //  hasMessageContaining : Exception 메시지에 입력된 문자열이 포함되는지 확인
    }
}

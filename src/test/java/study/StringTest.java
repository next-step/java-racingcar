package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
    @DisplayName("1, 2를 ,로 split 했을 때 [1, 2] 반환")
    @Test
    void split_ex1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("1을 ,로 split 했을 때 [1] 반환")
    @Test
    void split_ex2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("(1, 2)을 ,로 split 했을 때 '1,2' 반환")
    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메소드를 활용해 StringIndexOutOfBoundsException 을 발생시켜라 Type1")
    @Test
    void exception_ex1() {
        assertThatThrownBy(() -> {
            char c = "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }

    @DisplayName("charAt() 메소드를 활용해 StringIndexOutOfBoundsException 을 발생시켜라 Type2")
    @Test
    void exception_ex2() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = "abc".charAt(4);
                }).withMessageMatching("String index out of range: 4");
    }
}

package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
    @DisplayName("split 함수에 대한 학습 테스트")
    @Test
    void splitMultiCase() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }


    @DisplayName("substring 함수에 대한 학습 테스트")
    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("assertj exception 에 대한 학습 테스트")
    @Test
    void exceptionMultiCase() {
        assertThatThrownBy(() -> {
            char c = "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = "abc".charAt(4);
                }).withMessageMatching("String index out of range: 4");
    }
}

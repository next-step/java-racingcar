package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringTest {
    @DisplayName("','를 기준으로 숫자가 나뉜다.")
    @Test
    void splitWordTest() {
        String word = "1,2";
        String[] SeparateWords = word.split(",");
        assertThat(SeparateWords[0]).isEqualTo("1");
        assertThat(SeparateWords[1]).isEqualTo("2");
    }

    @DisplayName("입력값에 '()'가 오면 '()'을 제거한다.")
    @Test
    void replaceWordTest() {
        String word = "(1,2)";
        String substitutedWord = word.replaceAll("[(]", "").replaceAll("[)]", "");
        assertThat(substitutedWord).isEqualTo("1,2");
    }

    @DisplayName("입력값을 추출할 수 있다.")
    @Test
    void educeWordExceptionTest() {
        String word = "abc";
        char extractedWord = word.charAt(1);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            throw new IllegalArgumentException(String.valueOf(
                    assertThat(extractedWord).isEqualTo('b')));
        });
    }
}
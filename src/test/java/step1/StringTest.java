package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("1,2를 ,로 분리")
    void split() {
        // Given
        String test = "1,2";

        // When
        String[] result = test.split(",");

        // Then
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        // Given
        String test = "(1,2)";

        // When
        String result = test.substring(1,4);

        // Then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자 가져오기")
    @Test
    void 특정_위치의_문자_가져오기() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(() -> {
            // Given
            String test = "abc";

            // When
            char result = test.charAt(7);

            // Then
            assertThat(result).isEqualTo('b');
        }).withMessageMatching("String index out of range: \\d+");
    }
}



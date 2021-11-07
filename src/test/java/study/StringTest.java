package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
    @Test
    @DisplayName("콤마로 문자열 나누기")
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("범위 문자열 추출")
    void substringTest() {
        String value = "(1,2)";
        String result = value.substring(1, value.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자 포함 여부 확인")
    void charAtTest() {
        String value = "abc";
        int ascii = 97;
        for (int idx = 0; idx < value.length(); ++idx) {
            assertThat(value.charAt(idx)).isEqualTo((char) ascii++);
        }
    }

    @Test
    @DisplayName("문자열 체크 확인(범위 초과 예외)")
    void charAtTestWithException() {
        String value = "abc";
        AtomicInteger idx = new AtomicInteger(value.length());
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> value.charAt(idx.get()))
                .withMessage("String index out of range: " + idx.get());
    }
}

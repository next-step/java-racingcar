package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
    @Test
    @DisplayName("요구사항1 테스트")
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항2 테스트")
    void substringTest() {
        String value = "(1,2)";
        String result = value.substring(1, value.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 테스트")
    void charAtTest() {
        String value = "abc";
        int ascii = 97;
        AtomicInteger idx = new AtomicInteger(0);

        // 정상 범위 테스트
        for (; idx.get() < value.length(); ) {
            assertThat(value.charAt(idx.getAndIncrement())).isEqualTo((char) ascii++);
        }

        // 인덱스 크기 초과 예외 테스트
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> value.charAt(idx.get()))
                .withMessage("String index out of range: " + idx.get());
    }
}

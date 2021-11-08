package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@DisplayName("1단계 - String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("요구사항 1 - 데이터 여러개")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 1 - 데이터 하나")
    void splitOnlyOne() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void splitContainingBraces() {
        String sample = "(1,2)";

        String substring = sample.substring(1, sample.length() - 1);
        String[] result = substring.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 3 - chartAt, StringIndexOutOfBoundsException 테스트")
    void charAt() {
        String sample = "abc";

        assertThat(sample.charAt(1))
                .isEqualTo('b');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    sample.charAt(sample.length() + 5);
                });
    }
}

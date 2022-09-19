package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("split 메소드 학습 테스트")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring 메소드 학습 테스트")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드 학습 테스트")
    void charAt() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt 메소드 IndexOutOfBoundsException 발생 학습 테스트")
    void charAtException() {
        ThrowingCallable result = () -> "abc".charAt(3);

        assertThatThrownBy(result)
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(result)
            .withMessageMatching("String index out of range: 3");
    }
}

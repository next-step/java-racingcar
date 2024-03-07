import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void splitTest1() {
        String[] value = "1,2".split(",");
        assertThat(value).contains("1");
        assertThat(value).containsExactly("1","2");
    }

    @Test
    void splitTest2() {
        String[] value = "1".split(",");
        assertThat(value).contains("1");
        assertThat(value).containsExactly("1");
    }

    @ParameterizedTest
    @ValueSource(strings = {"(1,2)"})
    void substringTest(String text) {
        String value = text.substring(1, text.indexOf(")"));
        assertThat(value).isEqualTo("1,2");
    }

    @DisplayName("문자열에서 특정 위치의 문자를 확인하고 인덱스를 벗어나면 오류를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    void charAtTest(String text) {
        IntStream.range(0, text.length()).forEach(index -> {
            if (index > text.length()) {
                assertThatThrownBy(() -> {
                    throw new StringIndexOutOfBoundsException();
                }).isInstanceOf(IndexOutOfBoundsException.class)
                        .hasMessageContaining("Index: " + index
                                + " Size: " + text.length());
            }
        });
    }
}
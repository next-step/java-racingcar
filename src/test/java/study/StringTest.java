package study;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    @DisplayName("주어진 문자열을 ','를 구분자로 split()을 이용해서 분리할 수 있다.")
    @Test
    void split() {
        // given
        String str = "1,2";

        // when
        String[] tokens = str.split(",");

        // then
        assertAll(
                () -> assertThat(tokens).contains("1"),
                () -> assertThat(tokens).contains("2"),
                () -> assertThat(tokens).containsExactly("1", "2")
        );
    }

    @DisplayName("주어진 문자열을 substring()을 이용해서 괄호를 제거할 수 있다.")
    @Test
    void substring() {
        // given
        String str = "(1,2)";
        String expected = "1,2";

        // when
        String result = str.substring(1, 4);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("주어진 문자열을 charAt()을 이용해서 특정 위치의 문자를 가져올 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"a,0", "b,1", "c,2"})
    void charAt(char value, int index) {
        assertThat("abc".charAt(index)).isEqualTo(value);
    }

    @DisplayName("주어진 문자열의 길이를 초과하는 인덱스를 조회하는 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 10})
    void chatAtWithException(int index) {
        // when
        ThrowableAssert.ThrowingCallable callable = () -> "abc".charAt(index);

        // then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(index))
                .withMessageMatching("String index out of range: \\d+");
    }
}

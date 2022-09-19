package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringStudyTest {

    @Test
    @DisplayName("문자열 1,2 을 ,로 split 했을 때 1과 2로 잘 분리된다.")
    void string_split() {

        final String sut = "1,2";

        final String[] actual = sut.split(",");

        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 1을 ,로 split 했을 때 1만을 포함하는 배열을 반환한다.")
    void string_split_2() {

        final String sut = "1,";

        final String[] actual = sut.split(",");

        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 (1,2) 값을 ()을 제거하고 '1,2' 를 반환하도록 구현한다.")
    void string_split_3() {

        final String sut = "(1,2)";

        final String actual = sut.substring(1, sut.length() - 1);

        assertThat(actual).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("문자열 abc 에서 특정 위치의 문자를 가져온다.")
    void string_split_4(final int index, final char expect) {

        final String sut = "abc";

        assertThat(sut.charAt(index)).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    @DisplayName("문자열 abc 에서 범위를 벗어난 문자을 호출하면 익셉션 처리한다.")
    void string_split_5(final int index) {

        final String sut = "abc";

        assertThatThrownBy(() -> sut.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }
}

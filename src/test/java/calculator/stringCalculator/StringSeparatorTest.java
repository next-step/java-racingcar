package calculator.stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringSeparatorTest {

    @Test
    @DisplayName("콤마 구분자 테스트")
    void commaSplitTest() {
        StringSeparator separator = new StringSeparator();

        List<Integer> separateList = separator.separate("1,2");

        assertThat(separateList).containsExactly(1, 2);
    }

    @Test
    @DisplayName("콜론 구분자 테스트")
    void colonSplitTest() {
        StringSeparator separator = new StringSeparator();

        List<Integer> separateList = separator.separate("1:2");

        assertThat(separateList).containsExactly(1, 2);
    }

    @Test
    @DisplayName("콤마 콜론 구분자가 섞였을때 테스트")
    void mixedCommaColonSplitTest() {
        StringSeparator separator = new StringSeparator();

        List<Integer> separateList = separator.separate("1:2,3:4");

        assertThat(separateList).containsExactly(1, 2, 3, 4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//k\n1k2k3", "//&\n1&2&3", "//#\n1#2#3"})
    @DisplayName("커스텀 구분자 테스트")
    void customSplitTest(String input) {
        StringSeparator separator = new StringSeparator();

        List<Integer> separateList = separator.separate(input);

        assertThat(separateList).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("구분자가 없을 때 숫자만 리턴")
    void noSplitTest() {
        StringSeparator separator = new StringSeparator();

        List<Integer> separateList = separator.separate("135");

        assertThat(separateList).containsExactly(135);
    }

}
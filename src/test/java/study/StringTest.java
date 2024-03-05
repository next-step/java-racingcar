package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void splitDualElementsStringBySeparator() {
        // given
        String data = "1,2";

        // when
        String[] splitData = data.split(",");

        // then
        assertThat(splitData).contains("1", "2");
    }

    @Test
    void splitSingleElementStringBySeparator() {
        // given
        String data = "1";

        // when
        String[] splitData = data.split(",");

        // then
        assertThat(splitData).containsExactly("1");
    }

    @Test
    void splitDualElementsStringCoveredWithParenthesesBySeparator() {
        // given
        String data = "(1,2)";

        // when
        int firstIndex = 1;
        int lastIndex = data.length() - 1;
        String[] splitDataWithoutParentheses = data.substring(firstIndex, lastIndex).split(",");

        // then
        assertThat(splitDataWithoutParentheses).contains("1", "2");
    }

    @DisplayName("chatAt() 메소드를 사용하여 특정 위치의 character를 읽는다.")
    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void getSpecificCharacterWithCharAt(int index, char input) {
        // given
        String data = "abc";

        // then
        assertThat(data.charAt(index)).isEqualTo(input);
    }

    @DisplayName("Index를 초과하는 요소를 호출 할 경우 IndexOutOfBoundException이 발생한다.")
    @Test
    void throwIndexOutOfBoundsExceptionWhenInputOverIndexToCharAt() {
        // given
        String data = "abc";

        // when
        int dataOverSize = data.length() + 1;

        // then
        assertThatThrownBy(() -> data.charAt(dataOverSize))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: " + dataOverSize);
    }
}

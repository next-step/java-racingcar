package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    void splitStringByIncludedDivider() {
        String source = "1,2";
        String includedDivider = ",";
        String[] splitStrings = source.split(includedDivider);

        String[] expected = new String[]{"1", "2"};
        assertThat(splitStrings).contains(expected);
    }

    @Test
    void splitStringByNotIncludedDivider() {
        String source = "1";
        String notIncludedDivider = ",";
        String[] splitStrings = source.split(notIncludedDivider);

        String[] expected = new String[]{"1"};
        assertThat(splitStrings).containsExactly(expected);
    }

    @Test
    void substringByIndexes() {
        String source = "(1,2)";
        int startIndex = 1;
        int endIndex = 4;
        String actual = source.substring(startIndex, endIndex);

        String expected = "1,2";
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("charAt() 메소드는 인자로 주어진 인덱스에 해당하는 char를 반환한다.")
    @Test
    void charAtReturnCharOfGivenIndex() {
        String source = "abc";
        int indexOfSmallA = 0;

        char actual = source.charAt(indexOfSmallA);
        char expected = 'a';

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("charAt() 메소드는 인자로 주어진 인덱스가 인스턴스의 사이즈보다 크거나 같으면 IndexOutOfBoundException을 던진다. ")
    @Test
    void charAtThrowExceptionWhenGivenIndexIsOutOfBounds() {
        String source = "abc";
        int indexOutOfBound = source.length();

        assertThatThrownBy(() -> source.charAt(indexOutOfBound))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(String.valueOf(indexOutOfBound));
    }
}

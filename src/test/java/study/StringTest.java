package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void splitInOrder() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void returnOnlyNumberOne() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void removeParenthesisAndReturnNumberOneAndTwo() {
        String value = "(1,2)";
        String expectResult = "1,2";
        String result = value.substring(1, 4);
        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    @DisplayName("문자열의 특정 인덱스 위치의 문자를 추출할 때 범위를 벗어나면 StringIndexOutOfBoundsException이 발생하는지 검증")
    public void requirement3_whenGettingCharAtSpecificPosition() {

        String value = "abc";

        assertThatThrownBy(() -> {
            value.charAt(10);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("1,2\"을 ,로 split했을 때 1과 2가 반환되어야 한다.")
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되어야 한다.")
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때()을 제거하고 \"1,2\"를 반환해야 한다.")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열이 정상 범위에 해당하는 경우")
    void charAtSuccess() {
        String result = "abc";

        char a = result.charAt(0);
        char c = result.charAt(2);

        assertThat(a).isEqualTo('a');
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAtFail() {
        String result = "abc";
        int positiveCaseNumber = 3;
        int negativeCaseNumber = -1;

        assertThatThrownBy(
                () -> {
                    char positiveOverIndex = result.charAt(positiveCaseNumber);
                }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: " + positiveCaseNumber);

        assertThatThrownBy(
                () -> {
                    char negativeOverIndex = result.charAt(negativeCaseNumber);
                }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: " + negativeCaseNumber);
    }


}

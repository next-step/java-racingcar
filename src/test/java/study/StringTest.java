package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항1 : 1,2 를 ,로 split 한 배열은 1과 2를 요소로 가진다")
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1 : 문자열 1을 ,로 split 한 배열은 1만을 요소로 가진다")
    void split_shouldIgnoreLastDelimiter() {
        String[] actual = "1,".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 : (1,2)에서 substring 으로 괄호를 제거하고 split한 배열은 1과 2를 요소로 가진다")
    void split_substring() {
        String[] actual = "(1,2)".substring(1, 4).split(",");
        assertThat(actual).containsExactly("1","2");
    }

    @Test
    @DisplayName("요구사항 3 : String.charAt에 String 크기를 초과하는 인덱스 지정시 IndexOutOfBoundsException 이 발생한다")
    public void charAt_shouldThrowIndexOutOfBoundsException() {
        String sut = "abc";
        assertThat(sut.charAt(1)).isEqualTo('b');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->sut.charAt(3))
                .withMessageMatching("String index out of range: \\d$");
    }
}

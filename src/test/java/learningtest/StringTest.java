package learningtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("split은 구분자를 기준으로 나누어 배열을 반환한다")
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split 시 구분자가 존재하지 않다면 문자열 하나만 담긴 배열을 반환한다")
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring은 시작, 끝 인덱스 매개변수에 대한 부분 문자열을 반환한다")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt은 i번째 문자를 반환한다")
    void charAt1() {
        String given = "(1,2)";
        assertThat(given.charAt(0)).isEqualTo('(');
    }

    @Test
    @DisplayName("charAt에 범위 밖의 i를 매개변수로 넣으면 예외가 발생한다")
    void charAt2() {
        String given = "(1,2)";
        assertThatThrownBy(() -> given.charAt(-1))
            .isInstanceOf(StringIndexOutOfBoundsException.class);
        assertThatThrownBy(() -> given.charAt(given.length()))
            .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

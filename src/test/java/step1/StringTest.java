package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split1() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void split2() {
        String input = "1";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현")
    void substring() {
        String input = "(1,2)";
        String result = input.substring(input.indexOf("(") + 1, input.lastIndexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오도록 구현")
    // [참고] https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion
    void charAt() {
        String input = "abc";
        char result = input.charAt(input.length() - 1);
        assertThat(result).isEqualTo('c');
        assertThatCode(() -> input.charAt(input.length() - 1)).doesNotThrowAnyException();
        assertThatThrownBy(() -> input.charAt(input.length())).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StringTest {

    @Test
    void split_했을_때_1과_2로_분리() {
        String test = "1,2";
        String[] result = test.split(",");

        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_했을_때_1만_포함() {
        String test = "1";
        String[] result = test.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring_으로_괄호_제거() {
        String test = "(1,2)";
        String result = test.substring(1, test.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("chatAt 을 통해 특정 위치의 문자를 성공적으로 가져온다.")
    @Test
    void charAt_했을_때_특정_위치_문자_가져오기_성공() {
        String test = "abc";
        assertThat(test.charAt(1)).isEqualTo('b');
    }

    @DisplayName("chatAt 을 통해 특정 위치의 문자 가져올 때 위치 값이 벗어나 에러가 발생한다.")
    @Test
    void charAt_했을_때_특정_위치_문자_가져오기_실패() {
        String test = "abc";

        assertThatThrownBy(() -> test.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}

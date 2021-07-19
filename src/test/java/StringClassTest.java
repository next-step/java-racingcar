import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringClassTest {

    @Test
    @DisplayName("문자열을 , 기준으로 분리하여 반환한다.")
    void split() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");

        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 특정 위치값을 가져온다.")
    void charAt() {
        char result1 = "abc".charAt(0);
        char result2 = "abc".charAt(2);

        assertThat(result1).isEqualTo('a');
        assertThat(result2).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열의 특정 위치값을 가져올때 위치 값을 벗어나면 에러가 발생한다.")
    void charAtException() {
        assertThatThrownBy(() -> "abc".charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}

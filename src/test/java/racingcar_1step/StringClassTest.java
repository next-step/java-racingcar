package racingcar_1step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringClassTest {

    @Test
    @DisplayName("요구사항1 - split 반환값")
    void split() {
        String[] arr = "1,2".split(",");
        assertThat(arr).contains("1");
        assertThat(arr).contains("2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 - substring 반환값")
    void substring() {
        String str = "(1,2)";
        String answer = str.substring(str.indexOf('(') + 1, str.indexOf(')'));
        assertThat(answer).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 - 특정 문자 위치값 에러")
    void charAt() {
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}

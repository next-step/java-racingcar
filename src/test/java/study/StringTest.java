package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test @DisplayName("문자열 분리")
    void split()  {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");

        String[] result2 = "1,".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test @DisplayName("문자열 자르기")
    void substring() {
        String s = "(1,2)";
        String result = s.substring(1, s.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test @DisplayName("문자 위치 가져오기")
    void charAt() {
        String s = "abc";
        int index = 5;

        assertThat(s.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> s.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %d", index));

    }

}

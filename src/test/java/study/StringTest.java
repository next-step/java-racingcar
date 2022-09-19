package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] data = "1,2".split(",");
        assertThat(data).contains("1");
        assertThat(data).containsExactly("1", "2"); //순서보장 체크
        //ctl+shift+R : 테스트 실행
    }

    @Test
    void subString() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    void charAt() {
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> {
            data.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    data.charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }
}

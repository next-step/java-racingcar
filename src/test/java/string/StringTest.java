package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.String;

class StringTest {

    @Test
    @DisplayName("\"1,2\"를 ,로 split했을 때 1과 2로 잘 분리되는지 확인하는 테스트")
    void split() {
        String input = "1,2";

        assertThat(input.split(",")).contains("1");
        assertThat(input.split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split했을 때 1만을 포함하는 배열이 반환되는지 확인하는 테스트")
    void split_array() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 가 주어졌을 때 substring()의 결과가 \"1,2\"인지 확인하는 테스트")
    void substring() {
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()을 통해 특정 위치의 문자를 가져오는 테스트")
    void charAt() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(1)).isEqualTo('b');
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("특정 문자 위치 가지고 올 때 위치 값을 벗어나는지 테스트")
    void charAt_out_of_bounds() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}
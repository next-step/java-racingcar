package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("'1,2'을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("'1'을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.")
    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).contains("1").hasSize(1);
    }

    @DisplayName("'(1,2)'에서 ()을 제거하고 '1,2'가 반환되는지 확인한다.")
    @Test
    void subStringTest() {
        String input = "(1,2)";
        String subInput = input.substring(1, input.length() - 1);
        assertThat(subInput).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 Exception 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void charAtTest(int index) {
        assertThatThrownBy(() -> {
            "abc".charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: " + index);
    }
}

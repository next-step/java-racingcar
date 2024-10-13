package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class StringTest {


    @DisplayName("구분자를 둔 두 숫자가 split()으로 잘 분리되는지 테스트한다.")
    @Test
    void split1() {
        String string = "1,2";
        String[] splitedString = string.split(",");
        assertThat(splitedString).containsExactly("1", "2");
    }

    @DisplayName("구분되지 않는 문자를 split()으로 구분했을 때, 원래 값을 그대로 포함한다")
    @Test
    void split2() {
        String string = "1";
        String[] splitedString = string.split(",");
        assertThat(splitedString).containsExactly("1");
    }

    @DisplayName("String.substring()로 시작 인덱스와 끝 인덱스 값으로 문자열을 자를 수 있다.")
    @Test
    void substring() {
        String data = "(1,2)";

        String successResult = data.substring(1, 4);
        String failResult = data.substring(0, 4);
        assertThat(successResult).isEqualTo("1,2");
        assertThat(failResult).isNotEqualTo("1,2");
    }

    @DisplayName("String.charAt()으로 문자열의 특정 인덱스 값을 추출할 수 있다.")
    @Test
    void charAt() {
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');
        assertThat(data.charAt(data.length() - 1)).isEqualTo('c');
        assertThatThrownBy(() -> {
            data.charAt(data.length());
        }).isExactlyInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

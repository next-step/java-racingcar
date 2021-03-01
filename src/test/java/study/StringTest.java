package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class StringTest {

    @Test
    @DisplayName("','를 기준으로 문자열이 분리되어야 한다.")
    void splitByComma() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열에 분리 기준이 되는 패턴이 없는 경우에는 문자열 전체가 배열에 담겨 반환되어야 한다.")
    void splitWithoutPattern() {
        String[] result = "1".split(",");

        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("문자열의 특정 위치를 지정하면 거기에 있는 문자를 반환한다.")
    void getCharInAnyPosition() {
        String data = "abc";

        assertAll(
            () -> assertThat(data.charAt(0)).isEqualTo('a'),
            () -> assertThat(data.charAt(1)).isEqualTo('b'),
            () -> assertThat(data.charAt(2)).isEqualTo('c')
        );
    }

    @Test
    @DisplayName("문자열의 길이를 벗어난 위치에서 문자를 가져올 경우에는 예외가 발생한다.")
    void getCharOutOfRange() {
        String data = "abc";

        assertThatThrownBy(() -> data.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class);
    }

}

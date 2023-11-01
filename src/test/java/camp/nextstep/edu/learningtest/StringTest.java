package camp.nextstep.edu.learningtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("'1,2'를 ,로 split하면 '1' '2'가 담긴 배열이 반환된다")
    void split1() {
        // given
        String str = "1,2";
        String delimiter = ",";

        // when
        String[] result = str.split(delimiter);

        // then
        assertThat(result.length).isEqualTo(2);
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
    }

    @Test
    @DisplayName("'1'을 ,로 split하면 1만이 담긴 배열이 반환된다")
    void split2() {
        // given
        String str = "1";
        String delimiter = ",";

        // when
        String[] result = str.split(delimiter);

        // then
        assertThat(result.length).isEqualTo(1);
        assertThat(result[0]).isEqualTo("1");
    }

    @Test
    @DisplayName("charAt 메서드는 문자열의 특정 위치의 char을 반환한다")
    void charAt() {
        // given
        String str = "abc";

        // when, then
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메서드에 유효하지 않은 인덱스를 입력하면 예외가 발생한다")
    void charAt2() {
        // given
        String str = "abc";

        // when, then
        assertThatThrownBy(() -> {
            str.charAt(-1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
        
        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

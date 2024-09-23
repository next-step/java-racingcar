package step1.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringClassTest {

    @DisplayName("split 메소드로 '1,2'를 '1'과 '2'로 구분할 수 있다.")
    @Test
    void split() {
        // given
        String numberString = "1,2";

        // when
        String[] result = numberString.split(",");

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("split 메소드로 '1,'를 '1'로 구분할 수 있다.")
    @Test
    void splitReturnSingleElement() {
        // given
        String numberString = "1,";

        // when
        String[] result = numberString.split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @DisplayName("substring 메소드로 '(1,2)'에서 '1,2'로 스트링을 자를 수 있다.")
    @Test
    void substring() {
        // given
        String numberString = "(1,2)";
        // when
        String result = numberString.substring(1, 4);
        // then
        assertThat(result).isEqualTo("1,2");
    }

}

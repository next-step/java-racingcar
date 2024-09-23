package step1.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringClassTest {

    @DisplayName("Split 메소드로 '1,2'를 '1'과 '2'로 구분할 수 있다.")
    @Test
    void split() {
        // given
        String numberString = "1,2";

        // when
        String[] result = numberString.split(",");

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("Split 메소드로 '1,'를 '1'로 구분할 수 있다.")
    @Test
    void splitReturnSingleElement() {
        // given
        String numberString = "1,";

        // when
        String[] result = numberString.split(",");

        // then
        assertThat(result).containsExactly("1");
    }
}

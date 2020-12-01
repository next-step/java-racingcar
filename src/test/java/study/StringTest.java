package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringTest {

    @Test
    @DisplayName("문자열 여러개 split 테스트")
    void split_test() {
        // given
        String data = "1,2";

        // when
        String[] result = data.split(",");

        // then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("문자열 하나 split 테스트")
    void split_one_data_test() {
        // given
        String data = "1";

        // when
        String[] result = data.split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 substring 테스트")
    void substring_test() {
        // given
        String data = "(1,2)";

        // when
        String result = data.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chart() 예외 테스트")
    void charAt(){
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }
}

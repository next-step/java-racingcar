package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringTest {

    @Test
    @DisplayName("split() 메소드 사용, 문자열 자르기 테스트")
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
    @DisplayName("split() 메소드 사용, 문자열 하나 자르기 테스트")
    void split_one_data_test() {
        // given
        String data = "1";

        // when
        String[] result = data.split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 메소드 사용, 인덱스를 사용하여 문자열 자르기 테스트")
    void substring_test() {
        // given
        String data = "(1,2)";

        // when
        String result = data.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드 사용, 인덱스로 문자를 리턴하는 테스트")
    void charAt_test() {
        // given
        String result = "abc";

        // when & then
        assertThat(result.charAt(0)).as("서로 문자가 일치하지 않습니다").isEqualTo('a');
        assertThat(result.charAt(1)).as("서로 문자가 일치하지 않습니다").isEqualTo('b');
        assertThat(result.charAt(2)).as("서로 문자가 일치하지 않습니다").isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() 메소드 사용, 인덱스 값을 벗어나는 예외 테스트")
    void charAt_exception_test(){
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }
}

package string.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

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

    @DisplayName("charAt 메소드로 인자로 전달된 인덱스 위치의 문자를 가져올 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void charAt(int index) {
        //given
        String alphabets = "abc";
        char[] expected = {'a', 'b', 'c'};

        //when
        char result = alphabets.charAt(index);

        // then
        assertThat(result).isEqualTo(expected[index]);
    }

    @DisplayName("charAt 메소드 사용 시 인덱스 범위를 벗어나면 예외가 발생한다.")
    @Test
    void charAtWhenOutOfBoundIndex() {
        //given
        String alphabets = "abc";

        //when & then
        assertThatThrownBy(() -> alphabets.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}

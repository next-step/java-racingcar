package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리 된다")
    void split() {
        // given
        String target = "1,2";

        // when
        String[] result = target.split(",");

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 substring()을 통해 \"1,2\"를 반환 한다")
    void substring() {
        // given
        String target = "(1,2)";

        // when
        String result = target.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest(name = "\"abc\"에서 char({0})을 하면 {1}을 가져온다 ")
    @CsvSource({"0, 'a'", "1, 'b'", "2, 'c'"})
    void charAt(int index, char result) {
        // given
        String target = "abc";

        // when
        // then
        assertThat(target.charAt(index)).isEqualTo(result);
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다")
    void charAt2() {
        // given
        String target = "abc";

        // when
        // then
        assertThrows(StringIndexOutOfBoundsException.class, () -> target.charAt(-1));
        assertThrows(StringIndexOutOfBoundsException.class, () -> target.charAt(3));
    }

}

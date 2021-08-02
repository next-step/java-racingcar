package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {


    @Test
    @DisplayName("스플릿_콤마_1과2나눠지는지")
    void splitComma() {
        String[] split = "1, 2".split(",");
        assertThat(split).contains("1");

    }

    @Test
    @DisplayName("서브스트링을이용해_가로안에_문자열_뽑가")
    void subStringTest() {
        String subString = "(1, 2)".substring(1, 4);
        assertThat(subString).isEqualTo("1, 2");
    }

    @Test
    @DisplayName("특정위치의문자를가져올때그길이를_벗어나면예외처리테스트")
    void StringPositionException() {
        String abc = "abc";
        assertThatThrownBy(() ->
                abc.charAt(5)
        ).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 5");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    abc.charAt(5);
                }).withMessageMatching("String index out of range: 5");
    }


}

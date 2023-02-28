package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split1() {
        //given
        String str = "1,2";

        //when
        String[] actual = str.split(",");

        //then
        assertThat(actual).containsExactly("1", "2");
    }


    @Test
    public void split2() {
        //given
        String str = "1";

        //when
        String[] actual = str.split(",");

        //then
        assertThat(actual).contains("1");
    }

    @Test
    @DisplayName("문자열의 괄호를 제거합니다.")
    public void removeBracket() {
        //given
        String str = "(1,2)";

        //when
        String result = str.substring(1, 4);

        //then
        System.out.println("result = " + result);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 특정위치를 가져올때 위치 값을 벗어나면 예외가 발생한다.")
    public void getStrPosition() {
        //given
        String str = "abc";

        //when
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));

        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }
}

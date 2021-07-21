import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void split() {
        //given
        String str = "1,2";
        String[] expected = {"1", "2"};

        //when
        String[] actual = str.split(",");

        //then
        assertThat(actual).contains(expected);
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void split2() {
        //given
        String str = "1";
        String[] expected = {"1"};

        //when
        String[] actual = str.split(",");

        //then
        assertThat(actual).containsExactly(expected);
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하도록 구현한다.")
    void substring() {
        //given
        String str = "(1,2)";
        String expected = "1,2";

        //when
        String actual = str.substring(1, 4);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void charAt() {
        //given
        String str = "abc";
        Character expected = 'b';

        //when
        Character actual = str.charAt(1);

        //when then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하도 구현한다.\nㄹ")
    void indexOut() {
        //given
        String str = "abc";

        //when then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(4));

    }
}

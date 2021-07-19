package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    public void 문자열_분리_테스트() {
        //given
        String text = "1,2";
        String[] expected = {"1", "2"};

        //when
        String[] split = text.split(",");

        //then
        assertThat(split).contains(text);
        assertThat(split).isEqualTo(expected);
    }

    @Test
    public void 문자열_분리_테스트2() {
        //given
        String text = "1";
        String[] expected = {"1"};

        //when
        String[] split = text.split(",");

        //then
        assertThat(split).contains(text);
        assertThat(split).isEqualTo(expected);
    }

    @Test
    public void 문자열_SubString_테스트() {
        //given
        String text = "(1,2)";
        String expected = "1,2";

        //when
        String substring = text.substring(1, text.length() - 1);

        //then
        assertThat(substring).isEqualTo(expected);
    }

    @Test
    public void 문자열_특정위치_문자_가져오기_테스트_실패() {
        //given
        String text = "abc";

        //when, then
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            text.charAt(3);
        }).withMessageMatching("String index out of range: \\d+");
    }

    @Test
    public void 문자열_특정위치_문자_가져오기_테스트_실패2() {
        //given
        String text = "abc";

        //when, then
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            text.charAt(-1);
        }).withMessageMatching("String index out of range: -\\d+");
    }
}

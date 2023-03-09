package study;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StringTest {

    @Test
    void 문자열을_콤마_기준으로_split_한다() {
        String str = "1,2";

        //when
        String[] actual = str.split(",");

        //then
        assertThat(actual).containsExactly("1", "2");
    }


    @Test
    public void 특정_문자를_컴마_기준으로_split_후_해당문자열을_포함하는지_검증한다() {
        //given
        String str = "1";

        //when
        String[] actual = str.split(",");

        //then
        assertThat(actual).contains("1");
    }

    @Test
    public void 문자열의_괄호를_제거한다() {
        //given
        String str = "(1,2)";

        //when
        String result = str.substring(1, 4);

        //then
        System.out.println("result = " + result);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    public void 특정위치의_문자열을_가져올때_위치값을_벗어나면_예외를_발생시킨다() {
        // given
        String str = "abc";

        // when
        // then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3));


        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }
}

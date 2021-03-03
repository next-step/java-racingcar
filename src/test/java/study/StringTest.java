package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class StringTest {
    @Test
    void Given_StrAndDelim_When_Split_Then_StrSplitted() {
        //given
        String s = "1,2";
        String delim = ",";

        //when
        String[] result = s.split(delim);

        //then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void Given_BracketStr_When_Substring_Then_BracketDeleted() {
        //givein
        String s = "(1,2)";

        //when
        String result = s.substring(1, s.length() - 1);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void Given_Str_Abc_ValidIndex_When_CharAt_Then_ChatAtSpecificPosition() {
        //given
        String s = "abc";
        int index = 1;

        //when
        char r = s.charAt(index);

        //then
        assertThat(r).isEqualTo('b');
    }

    @Test
    void Given_Str_Abd_InvalidIndex_When_CharAt_Then_StringIndexOutOfBoundsException() {
        //given
        String s = "abc";
        int index = s.length() + 1;

        //then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    //when
                    s.charAt(index);
                });
    }
}



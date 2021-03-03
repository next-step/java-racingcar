package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class StringTest {
    @Test
    @DisplayName("문자열(String)과 구분자(Delim)이 있을 때, 문자열이 구분자 기준으로 잘 분리 되는지 테스트")
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
    @DisplayName("괄호()에 쌓여진 문자열에서 괄호가 없어지는지 테스트")
    void Given_BracketStr_When_Substring_Then_BracketDeleted() {
        //givein
        String s = "(1,2)";

        //when
        String result = s.substring(1, s.length() - 1);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 특정 위치의 문자가 잘 반환 되는지 테스트")
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
    @DisplayName("문자열에서 인덱스 밖의 문자에 접근했을 때 StringIndexOutOfBoundsException 발생 테스트")
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



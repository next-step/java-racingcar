package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringTest
{
    @Test
    void splitTest()
    {
        //given
        String str1 = "1,2";
        String str2 = "1";
        //when
        String[] str1Arr = str1.split(",");
        String[] str2Arr = str2.split(",");
        //then
        assertThat(str1Arr).contains("1");
        assertThat(str2Arr).containsExactly("1");
    }

    @Test
    void substringTest()
    {
        //given
        String str = "(1,2)";
        //when
        str = str.substring(1, 4);
        //then
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 특정 위치의 문자를 가져올 때 범위 벗어날 경우 IndexOutOfBoundsException 발생하는지 확인한다.")
    void charAtTest()
    {
        //given
        String str ="abc";
        //then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> str.charAt(3));
    }
}

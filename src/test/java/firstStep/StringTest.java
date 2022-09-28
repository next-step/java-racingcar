package firstStep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;



public class StringTest {

    @Test
    void splitTest(){
        //given
        String str = "1,2";
        String str2 = "1";
        //when
        String[] strArr =  str.split(",");
        String[] strArr2 = str2.split(",");

        //then
        assertThat(strArr).containsExactly("1", "2");
        assertThat(strArr2).contains("1");
    }

    @Test
    void subStringTest(){
        //given
        String str = "(1,2)";

        //when
        String subString = str.substring(1,4);

        //then
        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt test")
    void charAtTest(){
        //given
        String str = "abc";
        //then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() ->{
                    str.charAt(str.length());
                });
    }




}

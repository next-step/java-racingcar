import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringClassTest {
    @Test
    @DisplayName("\"1,2\"를 ,로 split 했을 때 분리되는지")
    void splitTest1(){
        //given
        String str = "1,2";

        //when
        String[] result = str.split(",");

        //Then
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 {\"1\"}로 반환되는지")
    void splitTest2(){
        String[] result = "1".split(",");

        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("substring()을 통해 ()제거")
    void subStringTest(){
        String str = "(1,2)";

        String result = str.substring(1,str.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()을 통해 문자열 범위 안 문자 가져오기")
    void charAt_범위_안(){
        final String str = "abc";

        char result = str.charAt(1);

        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt()을 통해 문자열 범위 밖 문자 가져오기")
    void charAt_범위_밖(){
        final String str = "abc";

        assertThatThrownBy(() ->{
            str.charAt(str.length());
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }

}

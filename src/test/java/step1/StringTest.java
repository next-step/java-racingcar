package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @Test
    @DisplayName("1,2가 주어졌을때 1 2가 배열로 있는지 확인을 한다.")
    void 요구사항_1_1(){
        //given
        String input = "1,2";
        //when
        String[] result = input.split(",");
        //then
        assertThat(result).contains("1","2");

    }

    @Test
    @DisplayName("1을 , 로 split했을때 1만을 포함하는 배열이 반환된다.")
    void 요구사항_1_2(){
        //given
        String input = "1";
        //when
        String[] result = input.split(",");
        //then
        assertThat(result).contains("1");

    }
    @Test
    @DisplayName("(1,2) 가 주어졌을때 ()를 제외한 1,2가 들어있는지 확인을 한다.")
    void 요구사항_2(){
        //given
        String input = "(1,2)";
        //when
        String result = input.substring(1 , input.length() -1);
        //then
        assertThat(result).isEqualTo("1,2");
    }
    @Test
    @DisplayName("String abe가 주어졌을 경우 String 클래스의 charAt(n) 메소드를 확인해서 n이 범위를 넘을 경우 익셉션이 발생한다.")
    void 요구사항_3(){
        //given
        String input = "abc";

        //then
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
        assertThatThrownBy(()-> input.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
        assertThatThrownBy(()-> input.charAt(-1)).isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

    @Test
    @DisplayName("1,2가 주어졌을때 1 2가 배열로 있는지 확인을 한다.")
    void 요구사항_1(){
        //given
        String input = "1,2";
        //when
        String[] result = input.split(",");
        //then
        assertThat(result).contains("1","2");

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
}

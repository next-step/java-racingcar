import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName("1,2가 주어졌을때 1 2가 배열로 있는지 확인을 한다.")
    void 요구사항_1(){
        //given
        String input = "1,2";
        //when
        String[] result = input.split(",");
        //then
        Assertions.assertThat(result).contains("1","2");

    }
}

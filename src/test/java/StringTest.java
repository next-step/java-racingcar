import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("String.split() 에 대한 학습 테스트")
    void splitMethodTest(){
        String numberList = "1,2";
        String singleNumber = "1";

        String[] numberListResult = numberList.split(",");
        String[] singleNumberResult = singleNumber.split(",");

        assertThat(numberListResult).contains("1","2");
        assertThat(singleNumberResult).containsExactly("1");
    }

    @Test
    @DisplayName("String.substring() 에 대한 학습 테스트")
    void substringMethodTest(){
        String indentString = "(1,2)";
        int stringLength = indentString.length();
        String[] result = indentString.substring(1,stringLength-1).split(",");

        assertThat(result).contains("1","2");
    }

    @Test
    @DisplayName("String.charAt() 의 동작 방식과 Exception 처리에 대한 학습 테스트")
    void charAtMethodTest(){
        String abcString = "abc";
        assertThatThrownBy(()->{
            char firstResult = abcString.charAt(0);
            char secondResult = abcString.charAt(1);
            char thirdResult = abcString.charAt(2);
            char unexpectedResult = abcString.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}

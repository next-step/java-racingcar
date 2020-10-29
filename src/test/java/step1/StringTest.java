package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("문자열 분리 테스")
    void split(){
        //요구사항 1
        //"1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        //"1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
        String oneAndTwo = "1,2";
        String one = "1";
        String[] splitOneAndTwo = oneAndTwo.split(",");
        String[] splitOne = one.split(",");

        assertThat(splitOneAndTwo).contains("1");
        assertThat(splitOneAndTwo).containsExactly("1","2");
        assertThat(splitOne).containsOnly("1");
        
    }
    
    @Test
    @DisplayName("문자열 substring 테스")
    public void substringTest() throws Exception{
        //요구사항 2
        //"(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
        String oneAndTwoWithParentheses = "(1,2)";
        String substring = oneAndTwoWithParentheses.substring(1, oneAndTwoWithParentheses.length()-1);
        assertThat(substring).isEqualTo("1,2");
    }
    
    @Test
    @DisplayName("charAt Exception 테스트")
    public void charAtExceptionTest() throws Exception{
        //요구사항 3
        //"abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        //String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        //JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

        String abc = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->abc.charAt(4))
                .withMessageMatching("String index out of range: \\d+");
    }
}

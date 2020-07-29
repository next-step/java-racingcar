package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    @Test
    @DisplayName("요구사항1 : String split()기능을 테스트")
    void splitTest(){
        String splitExampleInput = "1,2";

        String[] result = splitExampleInput.split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).contains("1","2");

        // containsExactly - 순서까지 일치 확인
//        assertThat(result).containsExactly("2","1");

        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("요구사항2 : String substring() 기능 테스트")
    void substringTest(){
        String subStringExampleInput = "(1,2)";

        String subString = subStringExampleInput.substring(1, 4);

        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3-1 : String charAt() 기능테스트")
    void charAtTest(){
        String charAtExampleInput = "abc";
        char targetChar = charAtExampleInput.charAt(1);

        assertThat(targetChar).isEqualTo('b');
    }

    @Test
    @DisplayName("요구사항3-2 : String charAt() OutOfBoundExample 테스트(assertThatThrownBy사용)")
    void charAtIndexOutofBoundsExample1Test(){
        assertThatThrownBy(() -> {
            String charAtExampleInput = "abc";
            charAtExampleInput.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("요구사항3-3 : String charAt() OutOfBoundExample 테스트(assertThatThrownBy사용-문구포함)")
    void charAtIndexOutofBoundsExample2Test(){
        assertThatThrownBy(() -> {
            String charAtExampleInput = "abc";
            charAtExampleInput.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    @Test
    @DisplayName("요구사항3-4 : String charAt() OutOfBoundExample 테스트(assertThatExceptionOfType)")
    void charAtIndexOutofBoundsExample3Test(){

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                String charAtExampleInput = "abc";
                charAtExampleInput.charAt(3);
            }).withMessageMatching("String index out of range: 3");
    }
}

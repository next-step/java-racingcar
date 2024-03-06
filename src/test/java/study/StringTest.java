package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    /**
     * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     * 힌트
     * 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
     * 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
     */
    @DisplayName("요구사항1")
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        //asserThat(param).containsExactly : Verifies that the actual array contains exactly the given values and nothing else, in order.
        assertThat(result).containsExactly("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    /**
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @DisplayName("with substring")
    @Test
    void splitWithSubstring() {

        String substring = "(1,2)".substring(1,4);
        /* 테스트 문자열을 바꾸며, 앞/뒤에 있는 괄호를 제거한다는 규칙일 경우 index기준으로 처음과 마지막을 제외한 값들 가져오기 */
        /*
        String testString = "(1,2)";
        String substring = testString.substring(1,testString.length()-1);
        */

        assertThat(substring).isEqualTo("1,2");
    }

    /**
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     *
     * 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
     * assertThatIllegalArgumentException()
     * assertThatIllegalStateException()
     * assertThatIOException()
     * assertThatNullPointerException()
     */
    @DisplayName("특정 문자열이 주어졌을때 처리1")
    @Test
    void catchBycharAt1() {

        String stringChar = "abc";
        
        //에러가 발생할 코드를 람다식 기준으로 입력
        assertThatThrownBy(() -> {
                        for (int i = 0; ; i++) {
                            stringChar.charAt(i);
                        }
                    }
                 )
                //기대되는 예외 class
                .isInstanceOf(IndexOutOfBoundsException.class) //
                //예외 class에서 발생시키는 메시지에 특정 설명(description)이 포함되어있는지 확인
                .hasMessageContaining("index out of range: " + String.valueOf(stringChar.length()))
        ;
    }
    
    @DisplayName("특정 문자열이 주어졌을때 처리2")
    @Test
    void catchBycharAt2() {

        String stringChar = "abc";
        
        //에러가 발생할 코드를 람다식 기준으로 입력
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                            for (int i = 0; ; i++) { //내부 소스가 예외를 발생하지 않을 경우 테스트가 실패한다.
                                stringChar.charAt(i);
                            }
                        }
                )
                .withMessageMatching("String index out of range: \\d")
        ;
    }
}

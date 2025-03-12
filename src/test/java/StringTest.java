import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringTest {
    /* 요구사항 1.
    * - "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    * - "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    void splitMultipleElementsTest() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void splitSingleElementTest() {
        String input = "1";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1");
    }

    /*요구사항 2
    * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    * */
    @Test
    void substringTest() {
        String input = "(1,2)";
        String result = input.substring(1,input.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    /* 요구사항 3
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Test
    void charAtTest() {
        String input = "abc";
        assertEquals('a', input.charAt(0));
        assertEquals('b', input.charAt(1));
        assertEquals('c', input.charAt(2));
    }

    @Test
    void charAtTest_InvalidIndex() {
        String input = "abc";
        int index = 100;

        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            input.charAt(index);
        }, "인덱스 " + index + " 은 문자열의 길이를 벗어나므로 예외가 발생해야 한다");
    }
}
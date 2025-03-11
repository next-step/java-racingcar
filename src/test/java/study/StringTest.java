package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스 테스트")
public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void 요구사항_1_1() {
        //given
        String commaNumber = "1,2";

        //when
        String[] numbers = commaNumber.split(",");

        //then
        assertThat(numbers).contains("1","2");
        assertThat(numbers).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void 요구사항_1_2() {
        //given
        String commaNumber = "1";

        //when
        String[] numbers = commaNumber.split(",");

        //then
        assertThat(numbers).contains("1");
        assertThat(numbers).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    void 요구사항_2() {
        //given
        String commaNumberInParentheses = "(1,2)";

        //when
        String commaNumber = commaNumberInParentheses.substring(1, commaNumberInParentheses.length()-1);

        //then
        assertThat(commaNumber).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void 요구사항_3_1() {
        //given
        String input = "abc";

        //when
        char a = input.charAt(0);
        char b = input.charAt(1);
        char c = input.charAt(2);

        //then
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void 요구사항_3_2() {
        //given
        String input = "abc";

        //when & then
        assertThatThrownBy(() -> input.charAt(input.length()))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("Index " + input.length() + " out of bounds for length " + input.length());
    }
}


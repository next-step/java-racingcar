package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @DisplayName("콤마(,)로 구분된 숫자를 콤마(,)를 기준으로 split 하면 숫자로 잘 분리되어야 한다.")
    @Test
    void splitNumbersTest() {
        // given
        String numbers = "1,2";

        // when
        String[] splitNumbers = numbers.split(",");

        // then
        assertThat(splitNumbers).contains("1", "2");
        assertThat(splitNumbers).containsExactly("1", "2");
    }

    @DisplayName("substring() 메소드를 사용해 양 끝의 괄호를 제거할 수 있다.")
    @Test
    void removeBothEndsOfBracketsTest() {
        // given
        String numbersWithBrackets = "(1,2)";

        // when
        String numbersWithoutBrackets = numbersWithBrackets.substring(1, numbersWithBrackets.length() - 1);

        // then
        assertThat(numbersWithoutBrackets).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메소드를 사용해 특정 위치의 문자를 가져올 수 있다.")
    @Test
    void getCharInSpecificPositionTest() {
        // given
        String str = "abc";

        // when
        char charInFirstPosition = str.charAt(0);
        char charInSecondPosition = str.charAt(1);
        char charInThirdPosition = str.charAt(2);

        // then
        assertThat(charInFirstPosition).isEqualTo('a');
        assertThat(charInSecondPosition).isEqualTo('b');
        assertThat(charInThirdPosition).isEqualTo('c');
    }

    @DisplayName("charAt() 메소드 사용시, 문자열의 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void getCharInOutOfBoundsPositionTest() {
        // given
        String str = "abc";

        // when, then
        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}

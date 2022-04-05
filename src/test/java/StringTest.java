import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("1,2 를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void twoNumberSplitTest() {
        String text = "1,2";

        String[] splitted = text.split(",");

        assertThat(splitted).contains("1", "2");
    }

    @Test
    @DisplayName("1 을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지")
    void oneNumberSplitTest() {
        String text = "1";

        String[] splitted = text.split(",");

        assertThat(splitted).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2 를 반환")
    void substringRemoveParenthesisTest() {
        String text = "(1,2)";

        String result = text.substring(1, text.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오기")
    void charAtTest() {
        String text = "abc";

        Character result = text.charAt(0);

        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("index 가 벗어난 charAt() 메서드의 StringIndexOutOfBoundsException 테스트")
    void charAtExceptionTest() {
        String text = "abc";

        assertThatThrownBy(() -> {
            Character result = text.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }


}

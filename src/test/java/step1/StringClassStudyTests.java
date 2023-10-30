package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringClassStudyTests {

    @Test
    @DisplayName("'1,2' 를 콤마 기준으로 split 했을 때 1과 2로 분리 되는지 확인")
    void splitStringByComma() {
        String target = "1,2";
        String[] splitedString = target.split(",");

        Assertions.assertThat(splitedString).contains("1");
        Assertions.assertThat(splitedString).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환 되는지 확인")
    void splitStringWithoutComma() {
        String target = "1";
        String[] splitedString = target.split(",");

        Assertions.assertThat(splitedString).contains("1");
        assertEquals(Arrays.toString(splitedString), "[1]");
    }

    @Test
    @DisplayName("(1,2) 가 주어졌을 때 subString()을 이용하여 괄호만 없애고 1,2만 출력한다.")
    void subStringBrackets() {
        String target = "(1,2)";
        String removeBrqcket = target.substring(1, target.length() - 1);

        assertEquals(removeBrqcket, "1,2");
    }

    @Test
    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습")
    void charAtTest() {
        String target = "abc";

        assertEquals(target.charAt(1), 'b');
        assertThatThrownBy(() -> target.charAt(4)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}

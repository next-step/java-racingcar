package FirstStepTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
    void splitTest1() {
        String target = "1,2";
        String[] result = target.split(",");

        assertThat(result).contains("1").contains("2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.")
    void SplitTest2() {
        String target = "1";
        String[] result = target.split(",");

        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하는지 확인한다.")
    void SubStringTest() {
        String target = "(1,2)";
        int startIndex = target.indexOf("(") + 1;
        int endIndex = target.indexOf(")");
        String result = target.substring(startIndex, endIndex);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인한다.")
    void CharAtTest() {
        String target = "abc";
        char result = target.charAt(0);

        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드에서 특정 위치 값을 벗어나면 발생하는 Exception을 확인한다.")
    void CharAtExceptionTest() {
        String target = "abc";
        int index = target.length();

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> target.charAt(index));
    }
}

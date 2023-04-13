import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void SplitTest1() {
        String str = "1,2";
        String[] strArray = str.split(",");
        String[] expectedArray = {"1", "2"};
        assertThat(strArray).containsExactly(expectedArray);
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만 포함하는 배열이 반환되는지 확인")
    void SplitTest2() {
        String str = "1";
        String[] strArray = str.split(",");
        String[] expectedArray = {"1"};
        assertThat(strArray).containsExactly(expectedArray);
    }

    @Test
    @DisplayName("(1,2)를 substring 했을 때 1,2문자열이 반환되는지 확인")
    void subStringPractice() {
        String str = "(1,2)";
        String expectedStr = "1,2";

        String actualStr = str.substring(1, 4);
        assertThat(actualStr).isEqualTo(expectedStr);
    }

    @Test
    @DisplayName("abc에서 charAt(0)을 했을때 a가 반환되는지 확인")
    void charAtStringPractice1() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("abc에서 charAt(5)을 했을때 StringIndexOutOfBoundsException가 반환되는지 확인")
    void charAtStringPractice2() {
        String str = "abc";
        assertThatThrownBy(() -> {
            str.charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: " + 5);
    }

}


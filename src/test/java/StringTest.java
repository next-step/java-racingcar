import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    // requirement 1
    @Test
    public void requirement1() {
        String input1 = "1,2";
        String input2 = "1";

        assertThat(input1.split(",")).contains("1");
        assertThat(input1.split(",")).containsExactly("1", "2");

        assertThat(input2.split(",")).containsExactly("1");
    }

    // requirement 2
    @Test
    public void requirement2() {
        String input = "(1,2)";

        assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
    }

    // requirement 3
    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 함수")
    public void requirement3() {
        String input = "abc";
        int successIdx = 2;

        assertThat(input.charAt(successIdx)).isEqualTo('c');

        int failIdx = 3;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(
                        () -> {
                            input.charAt(failIdx);
                        })
                .withMessageMatching(String.format("String index out of range: %d", failIdx));
    }
}

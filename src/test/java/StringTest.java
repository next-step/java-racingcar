import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringTest {
    @Test
    void splitTwoNumbersTest() {
        String target = "1,2";
        String delimiter = ",";
        
        String[] result = target.split(delimiter);
        assertThat(result).contains("1", "2");
    }

    @Test
    void splitOneNumberTest() {
        String target = "1";
        String delimiter = ",";

        String[] result = target.split(delimiter);
        assertThat(result).containsExactly("1");
    }

    @Test
    void substringTest() {
        String target = "(1,2)";

        String result = target.substring(1, target.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAtTest() {
        String target = "abc";

        char first = target.charAt(0);
        assertThat(first).isEqualTo('a');
        char second = target.charAt(1);
        assertThat(second).isEqualTo('b');
        char third = target.charAt(2);
        assertThat(third).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메서드 예외 테스트 - IndexOutOfBoundsException")
    void charAtExceptionTest() {
        String target = "abc";

        assertThatThrownBy(() -> {
            target.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}

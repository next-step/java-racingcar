import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringClassTest {

    @Test
    @DisplayName("split 학습 테스트")
    void one_and_two_split_test() {
        String input = "1,2";
        String[] splitInput =  input.split(",");
        assertThat(splitInput).contains("1","2");

        input = "1,";
        splitInput = input.split(",");
        assertThat(splitInput).containsExactly("1");
    }

    @Test
    @DisplayName("substring 학습 테스트")
    void substring_test() {
        String input = "(1,2)";
        String substringInput = input.substring(1,4);

        assertThat(substringInput).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chartAt 학습 테스트")
    void chartAt_test() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');

        assertThatThrownBy(()-> {
            input.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }
}

package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void spilt1() {
        final String[] actual = "1,2".split(",");
        // actual contain [1, 2]
        System.out.println(actual.toString());

        assertThat(actual).containsExactly("1", "2" );

    }

    @Test
    void split2() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void exam2() {
        // case1
        String[] actual = "(1,2)".replace("(", "").replace(")", "").split(",");
        assertThat(actual).containsExactly("1","2");

        // case2
        String actual2 = "(1,2)".replace("(", "").replace(")", "");
        assertThat(actual2).isEqualTo("1,2");
    }

    @DisplayName("범위를 넘어가는 index가 들어왔을때 예외처리")
    @ParameterizedTest
    @ValueSource(ints = {3,4,5, -1})
    void exam3(int index) {

        assertThatThrownBy(() -> "abc".charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range")
                .hasMessageContaining(String.valueOf(index));

    }

}

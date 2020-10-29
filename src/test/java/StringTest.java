import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    @DisplayName("1,2 ,로 분리")
    void splitWithRestChar(){
        String[] splits = "1,2".split(",");

        assertThat(splits).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1 ,로 분리")
    void splitWithRestChar_noRestChar(){
        String[] split = "1".split(",");

        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)를 ()제거")
    void removeBrackets() {
        String bracketsRemoved = "(1,2)".substring(1, 4);

        assertThat(bracketsRemoved).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()에서 위치값 벗어난 에러")
    void failUsingCharAt_indexOutOfBounds() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3));
    }
}

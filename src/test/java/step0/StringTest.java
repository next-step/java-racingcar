package step0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("요구사항 1")
    void quest1() {
        String[] array1 = "1,2".split(",");
        String[] array2 = "1".split(",");
        assertAll(
                () -> assertThat(array1).containsExactly("1", "2"),
                () -> assertThat(array2).containsOnly("1")
        );
    }

    @Test
    @DisplayName("요구사항 2")
    void quest2() {
        String input = "(1,2)";
        assertThat(input.substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3")
    void quest3() {
        String input = "abc";
        assertEquals(input.charAt(1), "a");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(Integer.MAX_VALUE);
                }).withMessageContaining("index");
    }

}

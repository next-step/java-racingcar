package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.predicate;

public class StringTest {

    @Nested
    class Split {
        @Test
        @DisplayName(" '1,2' 를 ,로 분리했을때, 1 과 2로 분리가 된다.")
        void splitByComma() {
            String data = "1,2";
            String[] splitByCommaArray = data.split(",");
            assertThat(splitByCommaArray).contains("1", "2");
        }

        @Test
        @DisplayName(" '1,' 를 , 로 분리했을때, 1만을 가지고 있다.")
        void splitByCommaContainsOnly1() {
            String data = "1,";
            String[] splitByCommaArray = data.split(",");
            assertThat(splitByCommaArray).containsOnly("1");
        }
    }

    @Test
    @DisplayName("(1,2)에서 ()를 제거하고 값을 반환한다.")
    void subString() {
        String data = "(1,2)";
        String splitBy = data.substring(1, 4);
        assertThat(splitBy).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 chartAt 인자가 Max Index 를넘을 경우 StringIndexOutOfBoundsException을 반환한다.")
    void whenExceedIndexException() {
        String data = "abc";
        assertThatThrownBy(() -> {
            data.charAt(10);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 10");
    }
}

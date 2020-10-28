package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("String의 split() 메소드 활용")
    void requirement_1() {
        // Given
        String source = "1,2";

        // When
        String[] result = source.split(",");

        // Then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String의 substring() 메소드 활용")
    void requirement_2() {
        // Given
        String source = "(1,2)";

        // When
        String substring = source.substring(source.indexOf("(") + 1, source.indexOf(")"));

        // Then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    void requirement_3() {

        assertThatThrownBy(() -> {
            // Given
            String source = "abc";

            // When
            source.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 3");

    }


}

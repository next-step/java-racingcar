package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringClassTest {

    @DisplayName("String 클래스에 대한 학습 테스트 / 요구사항 1")
    @Test
    void string_split() {

        String[] numberArray = "1,2".split(",");
        assertThat(numberArray).contains("1", "2");

        numberArray = "1".split(",");
        assertThat(numberArray).contains("1");

    }

    @DisplayName("String 클래스에 대한 학습 테스트 / 요구사항 2")
    @Test
    void string_substring() {

        String number = "(1,2)";
        String numberSubstring = number.substring(1, number.length() - 1);
        assertThat(numberSubstring).isEqualTo("1,2");

    }

    @DisplayName("String 클래스에 대한 학습 테스트 / 요구사항 3")
    @Test
    void string_charAt() {

        assertThatThrownBy(() -> {
            "abc".charAt(Integer.MAX_VALUE);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("string index out of range");

    }

}

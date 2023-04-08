package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@Nested
@DisplayName("first next step test")
public class StringTest {
    @Test
    @DisplayName("test split")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");

        String[] result2 = "1".split(",");
        for (String s : result2) {
            assertThat(s).contains("1");
        }
    }

    @Test
    @DisplayName("test substring")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("test charAt")
    void charAt() {
        String request = "abc";
        int index = 10;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() ->{
            request.charAt(index);
        }).withMessage("string index out of range: %s", index);
    }

    //****** code review

    @Test
    @DisplayName("test numbers split")
    void splitNumbers() {
        //given
        String numbersString = "1,2";

        //when
        String[] numbersArray = numbersString.split(",");

        //then
        assertThat(numbersArray).contains("1");
        assertThat(numbersArray).containsExactly("1","2");
    }

    @Test
    @DisplayName("test number split")
    void splitNumber() {
        //given
        String numberString = "1";

        //when
        String[] numberArray = numberString.split(",");

        //then
        for (String number : numberArray) {
            assertThat(number).contains("1");
        }
    }
}
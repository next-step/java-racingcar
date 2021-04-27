package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
public class StringTest2 {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertThat(number).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        System.out.println("sssss"+input.isEmpty());
        assertThat(input).isEmpty();
    }

    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
        String actualValue = input.toLowerCase();
        assertThat(expected).isEqualTo(actualValue);
    }
    @DisplayName("전부쪼개기")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2"})
    void caltests(String input){
        System.out.print(input);
//        Cal ca = new Cal();
//        ca.splitWord(input);

    }
}

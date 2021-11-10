package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IntNumberTest {

    @DisplayName("문자 혹은 int로 Number를 생성 후, int로 다시 꺼내서 비교")
    @ParameterizedTest
    @CsvSource(value = { "1:1:1", "-1:-1:-1" }, delimiter = ':')
    void createNumber(String stringNumber, int intNumber, int expected) {
        IntNumber numberFromString = new IntNumber(stringNumber);
        IntNumber numberFromInt = new IntNumber(intNumber);

        assertThat(numberFromString.value()).isEqualTo(expected);
        assertThat(numberFromInt.value()).isEqualTo(expected);
    }
}

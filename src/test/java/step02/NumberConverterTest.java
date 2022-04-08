package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumberConverterTest {

    private final NumberConverter numberConverter = new NumberConverter();

    @Test
    @DisplayName("문자열 수를 정수로 변경한다")
    void convertTest() {
        //given
        List<String> givenValues = List.of("0", "1", "2");

        //when
        List<Number> numbers = numberConverter.convertToNumber(givenValues);

        //then
        assertThat(numbers.containsAll(
                List.of(
                        NumberFactory.from(0),
                        NumberFactory.from(1),
                        NumberFactory.from(2))
        )).isTrue();
    }
}
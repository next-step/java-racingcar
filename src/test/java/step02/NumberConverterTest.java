package step02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class NumberConverterTest {

    private final NumberConverter numberConverter = new NumberConverter();

    @Test
    @DisplayName("문자열 수를 정수로 변경한다")
    void convertTest() {
        //given
        List<String> givenValues = List.of("0", "1", "2");

        //when
        List<Integer> numbers = numberConverter.convertToNumber(givenValues);

        //then
        Assertions.assertThat(numbers.containsAll(List.of(0, 1, 2))).isTrue();
    }
}
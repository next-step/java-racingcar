package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringSumTest {

    private StringSum stringSum;

    @BeforeEach
    void setUp() {
        stringSum = new StringSum();
    }

    @ParameterizedTest
    @DisplayName("쉼표로 들어오는 숫자의 합을 반환할 수 있다.")
    @CsvSource(value = {"1,2=3", "1,2,3=6", "1,2,3,4=10"}, delimiter = '=')
    void sumStringByCommaTest(String data, int expected) {
        // when
        int result = stringSum.sumStringByDelimiter(data);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("콜론으로 들어오는 숫자의 합을 반환할 수 있다.")
    @CsvSource(value = {"1:2=3", "1:2:3=6", "1:2:3:4=10"}, delimiter = '=')
    void sumStringByColonTest(String data, int expected) {
        // when
        int result = stringSum.sumStringByDelimiter(data);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("쉼표 혹은 콜론으로 들어오는 숫자의 합을 반환할 수 있다.")
    @CsvSource(value = {"1:2=3", "1,2:3=6", "1,2:3,4=10"}, delimiter = '=')
    void sumStringByDelimiterTest(String data, int expected) {
        // when
        int result = stringSum.sumStringByDelimiter(data);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자를 사용해서 합을 구할 수 있다.")
    @MethodSource("provideStringsForCustomDelimiter")
    void customDelimiterSumTest(String data, int expected) {
        // when
        int result = stringSum.sumStringByDelimiter(data);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideStringsForCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//!\n1!2!3", 6)
        );
    }
}

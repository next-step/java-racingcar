package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DisplayName("입력된 문자열")
class LettersTest {
    @ParameterizedTest
    @CsvSource(value = {"1 2 3 4 5=5", "2=1"}, delimiter = '=')
    void 입력된_문자열_공백타입으로_글자_자른다(String input, int resultSize) {
        List<String> inputs = Letters.convertStringToStrings(input);
        assertThat(inputs.size()).isEqualTo(resultSize);
    }
}
package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;

@DisplayName("입력된 문자열")
class LettersTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 입력_값이_null이거나_빈_공백_문자일_경우_IllegalArgumentException(String input) {
        assertThatThrownBy(() -> {
            Letters.checkBlack(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("값을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 2 3 4 5=5", "2=1"}, delimiter = '=')
    void 입력된_문자열_공백타입으로_글자_자른다(String input, int resultSize) {
        List<String> inputs = Letters.convertStringToStrings(input);
        assertThat(inputs.size()).isEqualTo(resultSize);
    }
}
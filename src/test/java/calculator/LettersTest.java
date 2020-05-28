package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;

@DisplayName("입력된 문자열")
class LettersTest {
    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("입력된 값이 null 값인지 체크")
    void checkBlank(String input) {
        assertThatThrownBy(() ->
                Letters.checkBlank(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("값을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 2 3 4 5=5", "2=1"}, delimiter = '=')
    @DisplayName("입력된 문자열을 공백형태로 자른 후 갯수 체크한다")
    void splitBlank(String input, int resultSize) {
        List<String> inputs = Letters.splitBlank(input);
        assertThat(inputs.size()).isEqualTo(resultSize);
    }
}
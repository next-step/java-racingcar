package stringaddcalculator.support;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3"})
    @DisplayName("기본 split 조건인 콤마(,)를 구분자로 하여 입력한 문자열을 배열로 생성한다.")
    void splitter_base_regex_comma(String inputString) {
        String[] result = Splitter.splitInputString(inputString);

        assertThat(result).hasSize(3)
                .contains("1")
                .contains("2")
                .contains("3");

    }
}
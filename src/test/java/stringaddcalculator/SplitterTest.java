package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @Test
    @DisplayName("기본 split 조건인 콤마(,)를 구분자로 하여 입력한 문자열을 배열로 생성한다.")
    void splitter_base_regex_comma() {
        String inputString = "1,2,3";

        String[] result = Splitter.splitInputString(inputString);

        assertThat(result).hasSize(3)
                .contains("1")
                .contains("2")
                .contains("3");

    }

    @Test
    @DisplayName("기본 split 조건인 콜론(:)를 구분자로 하여 입력한 문자열을 배열로 생성한다.")
    void splitter_base_regex_colon() {
        String inputString = "1:2:3";

        String[] result = Splitter.splitInputString(inputString);

        assertThat(result).hasSize(3)
                .contains("1")
                .contains("2")
                .contains("3");
    }

}
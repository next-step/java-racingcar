package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import caculator.StringSplitter;

class StringSplitterTest {

    @Test
    @DisplayName("쉼표(,), 콜론(:), 열 앞부분의 “//”와 “\\n” 사이에 위치하는 커스텀 구분자를 기준으로 문자열을 분리한다. ")
    public void test_string_split() {
        assertThat(StringSplitter.split("//;\n1;2;3")).containsExactly("1", "2", "3");
    }
}
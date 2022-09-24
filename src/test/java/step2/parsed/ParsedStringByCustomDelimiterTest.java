package step2.parsed;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ParsedStringByCustomDelimiterTest {

    @Test
    @DisplayName("문자열에 음수가 있는 경우 예외가 발생한다")
    void a() {
        String stringToBeParsed = "//-1\n";
        Parsed sut = new ParsedStringByDefaultDelimiter(stringToBeParsed);

        Assertions.assertThatThrownBy(() -> sut.parsedValue())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수를 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("문자열 첫 부분에 // 와 \n 사이에 문자가 있을 경우 해당 문자를 구분자로 문자열을 나눌 수 있다.")
    void b() {
        String stringToBeParsed = "//;\n1;2";
        Parsed sut = new ParsedStringByCustomDelimiter(stringToBeParsed);

        List<String> parsedValue = sut.parsedValue();

        Assertions.assertThat(parsedValue).containsExactly("1", "2");
    }

}

package step2.parsed;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParsedStringTest {

    @Test
    @DisplayName("문자열에 음수가 있는 경우 예외가 발생한다")
    void a() {
        String stringToBeParsed = "-1";
        Parsed sut = new ParsedString(stringToBeParsed);

        Assertions.assertThatThrownBy(() -> sut.parsedValue())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수를 입력할 수 없습니다.");
    }

}

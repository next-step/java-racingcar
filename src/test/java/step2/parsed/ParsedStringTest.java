package step2.parsed;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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

    @Test
    @DisplayName("숫자 이외의 문자에 대한 유효성 검증")
    void b() {
        String stringToBeParsed = "*";
        Parsed sut = new ParsedString(stringToBeParsed);

        Assertions.assertThatThrownBy(() -> sut.parsedValue())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자 이외의 문자를 입력할 수 없습니다.");
    }

    @ValueSource(strings = {
            "1,2",
            "1:2"
    })
    @ParameterizedTest
    @DisplayName("쉼표(,)와 콜론(:)을 구분자를 가지는 문자열 일 경우 구분자로 기준으로 분리된 숫자들을 반환한다")
    void c(String stringToBeParsed) {
        Parsed sut = new ParsedString(stringToBeParsed);

        List<String> parsedValue = sut.parsedValue();

        Assertions.assertThat(parsedValue).containsExactly("1", "2");
    }

}

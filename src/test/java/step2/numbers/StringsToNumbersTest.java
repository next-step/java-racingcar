package step2.numbers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.parsed.Parsed;
import step2.parsed.ParsedStringByDefaultDelimiter;

import java.util.List;
import java.util.stream.Stream;

class StringsToNumbersTest {

    @Test
    @DisplayName("파싱된 문자열 리스트를 숫자 리스트로 변환할 수 있다.")
    void a() {
        String stringToBeParsed = "1,2,3";
        Parsed parsed = new ParsedStringByDefaultDelimiter(stringToBeParsed);
        Numbers sut = new StringsToNumbers(parsed);

        List<Integer> numbers = sut.numbers();

        Assertions.assertThat(numbers).containsExactly(1, 2, 3);
    }


    @MethodSource
    @ParameterizedTest
    @DisplayName("문자열이 숫자가 아니거나 음수일 경우 예외가 발생한다")
    void b(Parsed parsed) {
        Numbers sut = new StringsToNumbers(parsed);

        Assertions.assertThatThrownBy(() -> sut.numbers())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아니거나 음수입니다.");
    }

    private static Stream<Arguments> b() {
        return Stream.of(
                Arguments.of(new Parsed.Fake(List.of("a"))),
                Arguments.of(new Parsed.Fake(List.of("-1")))
        );
    }

}

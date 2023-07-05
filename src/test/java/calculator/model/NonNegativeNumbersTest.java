package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import calculator.parser.TextSplitter;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class NonNegativeNumbersTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("입력받은 값으로 객체 생성하기")
    void createTextTest(final TextSplitter textSplitter) {
        assertThatCode(
                () -> NonNegativeNumbers.of(textSplitter)
        ).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("저장한 모든 수의 합 구하기")
    void sumTest() {
        final NonNegativeNumbers numbers = NonNegativeNumbers.of(
                new TextSplitter("1,2:3")
        );
        assertThat(numbers.sum()).isEqualTo(6);
    }

    private static Stream<? extends TextSplitter> createTextTest() {
        return Stream.of(
                new TextSplitter(""),
                new TextSplitter("1"),
                new TextSplitter("1,2,3"),
                new TextSplitter("1,2:3")
        );
    }

}
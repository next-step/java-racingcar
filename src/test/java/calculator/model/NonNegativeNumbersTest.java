package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class NonNegativeNumbersTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("입력받은 값으로 객체 생성하기")
    void correctValuesTest(final List<String> values) {
        assertThatCode(() -> NonNegativeNumbers.of(values)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("잘못된 입력값으로 객체를 생성")
    void wrongValuesTest(final List<String> values) {
        assertThatThrownBy(() -> NonNegativeNumbers.of(values)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("저장한 모든 수의 합 구하기")
    void sumTest() {
        final NonNegativeNumbers numbers = NonNegativeNumbers.of(List.of("1", "2", "3"));
        assertThat(numbers.sum()).isEqualTo(6);
    }

    private static Stream<List<String>> correctValuesTest() {
        return Stream.of(
                List.of(""),
                List.of("1"),
                List.of("1", "2", "3")
        );
    }

    private static Stream<List<String>> wrongValuesTest() {
        return Stream.of(
                List.of("-1"),
                List.of("1", "-1")
        );
    }
}
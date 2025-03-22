package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RecordTest {

    @ParameterizedTest
    @DisplayName("이름이 null, 빈 문자열, 공백 문자열이면 예외를 던진다.")
    @MethodSource("invalidNames")
    void recordNameValidationTest(String invalidName) {
        Assertions.assertThatThrownBy(() -> new Record(invalidName, 1, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 이름입니다: ");

    }

    static Stream<String> invalidNames() {
        return Stream.of(
                null,
                "",
                "   ",
                "\t",
                "\n"
        );
    }

    @ParameterizedTest(name = "position={0}, attempt={1}")
    @DisplayName("position 또는 attempt가 음수면 예외를 던진다.")
    @MethodSource("invalidNumbers")
    void recordNegativeNumberValidationTest(int position, int attempt) {
        Assertions.assertThatThrownBy(() -> new Record("name", position, attempt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수의 입력값만 받을 수 있습니다");
    }

    static Stream<Arguments> invalidNumbers() {
        return Stream.of(
                Arguments.of(-1, 0),
                Arguments.of(0, -1),
                Arguments.of(-5, -3)
        );
    }

    @Test
    @DisplayName("올바른 값이 들어오면 정상적으로 Record가 생성된다.")
    void recordValidCreationTest() {
        Record record = new Record("name", 1, 3);

        Assertions.assertThat(record)
                .isNotNull()
                .extracting("name", "position", "attempt")
                .containsExactly("name", 1, 3);
    }



}
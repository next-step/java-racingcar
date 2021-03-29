package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static racingcar.exception.Message.MAX_LENGTH_ERROR;
import static racingcar.exception.Message.NULL_OR_EMPTY_ERROR;

public class NameTest {

    static Stream<Arguments> namingError() {
        String wrongName = "abcdef";
        return Stream.of(
                arguments(null, NULL_OR_EMPTY_ERROR),
                arguments("", NULL_OR_EMPTY_ERROR),
                arguments(wrongName, MAX_LENGTH_ERROR)
        );
    }

    @Test
    @DisplayName("생성자 테스트")
    void create() {
        assertThat(new Name("pobi")).isEqualTo(new Name("pobi"));
    }

    @ParameterizedTest
    @DisplayName("공백, 5자 초과 시 예외 리턴 테스트")
    @MethodSource("namingError")
    void validateName(String name, String errorMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(name))
                .withMessage(errorMessage);
    }
}

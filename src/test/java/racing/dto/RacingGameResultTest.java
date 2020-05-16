package racing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameResultTest {

    @ParameterizedTest
    @MethodSource("provideNotValidNames")
    @DisplayName("비어있는 cars 객체로 생성했을 경우 Exception")
    void validateGameResultByEmptyName(String name, int position) {
        assertThatThrownBy(() -> this.createRacingGameResult(name, position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNotValidNames() {
        return Stream.of(
                Arguments.of("", 1),
                Arguments.of(null, 1)
        );
    }

    private RacingGameResult createRacingGameResult(String name, int position) {
        return new RacingGameResult(name, position);
    }
}

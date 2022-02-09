package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.movable.RandomMovableStrategy;

public class GameControllerTest {

    static Stream<Arguments> generateValidGameControllerParameter() {
        return Stream.of(
            Arguments.of("a, b, c, d", 1),
            Arguments.of("a, b, c, d, e", 10),
            Arguments.of("a, b, c, d, e", 20)
        );
    }

    static Stream<Arguments> generateInvalidTurnGameControllerParameter() {
        return Stream.of(
            Arguments.of("a, b, c", 0),
            Arguments.of("a, b, c, d", 0),
            Arguments.of("a, b, c, d, e", 0)
        );
    }

    @DisplayName("GameController에 유효한 인자로 넣었을때, startGame 메서드가 정상 작동한다.")
    @ParameterizedTest
    @MethodSource("generateValidGameControllerParameter")
    void GivenValidGameControllerParameter_WhenStartGame_ThenNotThrowException(String carNames,
        int turn) {
        assertDoesNotThrow(
            () -> GameController.of(carNames, turn)
                .startGame(RandomMovableStrategy.getInstance())
        );
    }

    @DisplayName(value = "GameController에 turn을 0으로 인자를 넣었을때, IllegalArgumentException가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateInvalidTurnGameControllerParameter")
    void GivenTurnZero_WhenStartGame_ThenIllegalArgumentException(String carNames, int turn) {
        assertThatThrownBy(
            () -> GameController.of(carNames, turn)
                .startGame(RandomMovableStrategy.getInstance())
        ).isInstanceOf(IllegalArgumentException.class);
    }
}

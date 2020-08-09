package racingcar;

import exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    private static final int ZERO = 0;
    private RacingGame racingGame;

    @DisplayName("progress 메소드 테스트")
    @Test
    void progress_test() {
        int car = 3;
        int attempt = 5;

        racingGame = RacingGame.of(car, attempt);
        RacingResult racingResult = racingGame.progress();

        assertThat(racingResult).isNotNull();
        assertThat(racingResult.getAttempt()).isEqualTo(attempt);
    }

    @DisplayName("checkAvailableGame 메소드 테스트")
    @ParameterizedTest
    @MethodSource("provideGameValidInput")
    void checkAvailableGame_test(int carNumber, int attemptNumber) {
        racingGame = RacingGame.of(carNumber, attemptNumber);

        assertThatCode(() -> racingGame.checkAvailableGame()).doesNotThrowAnyException();;
    }

    @DisplayName("checkAvailableGame 메소드 예외 반환 테스트")
    @ParameterizedTest
    @MethodSource("provideGameInvalidInput")
    void checkAvailableGame_test(int carNumber, int attemptNumber, String exceptionMessage) {
        racingGame = RacingGame.of(carNumber, attemptNumber);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> racingGame.checkAvailableGame())
                .withMessage(exceptionMessage);
    }

    private static Stream<Arguments> provideGameValidInput() {
        return Stream.of(
                Arguments.of(3, 1),
                Arguments.of(1000, 22)
        );
    }

    private static Stream<Arguments> provideGameInvalidInput() {
        return Stream.of(
                Arguments.of(ZERO, ZERO, ExceptionMessage.INVALID_RACING_CAR_NUMBER),
                Arguments.of(2, ZERO, ExceptionMessage.INVALID_RACING_ATTEMPT_NUMBER),
                Arguments.of(-1, 33, ExceptionMessage.INVALID_RACING_CAR_NUMBER)
        );
    }
}
package racingcar;

import exception.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    private static final int ZERO = 0;
    private RacingGame racingGame;
    private List<String> carName;

    @BeforeEach
    void setUp() {
        carName = Arrays.asList("happy", "sad", "sick", "merry");
    }

    @DisplayName("progress 메소드 테스트")
    @Test
    void progress_test() {
        int attempt = 5;

        racingGame = RacingGame.of(carName, attempt);
        RacingResult racingResult = racingGame.progress(new RandomNumberMover());

        assertThat(racingResult).isNotNull();
        assertThat(racingResult.getAttempt()).isEqualTo(attempt);
    }

    @DisplayName("checkAvailableGame 메소드 테스트")
    @ParameterizedTest
    @MethodSource("provideGameValidInput")
    void checkAvailableGame_test(List<String> carNames, int attemptNumber) {
        racingGame = RacingGame.of(carNames, attemptNumber);

        assertThatCode(() -> racingGame.checkAvailableGame()).doesNotThrowAnyException();;
    }

    @DisplayName("checkAvailableGame 메소드 예외 반환 테스트")
    @ParameterizedTest
    @MethodSource("provideGameInvalidInput")
    void checkAvailableGame_test(List<String> carNames, int attemptNumber, String exceptionMessage) {
        racingGame = RacingGame.of(carNames, attemptNumber);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> racingGame.checkAvailableGame())
                .withMessage(exceptionMessage);
    }

    private static Stream<Arguments> provideGameValidInput() {
        return Stream.of(
                Arguments.of(Arrays.asList("happy", "sad", "sick"), 4),
                Arguments.of(Arrays.asList("are", "you"), 3)
        );
    }

    private static Stream<Arguments> provideGameInvalidInput() {
        return Stream.of(
                Arguments.of(Arrays.asList("happy", "pleasure", "sad", "sick"), 5, ExceptionMessage.RACING_CAR_NAME_IS_TOO_LONG),
                Arguments.of(Arrays.asList(""), 4, ExceptionMessage.RACING_CAR_NAME_IS_TOO_SHORT),
                Arguments.of(Arrays.asList("happy", "sad", "sick"), ZERO, ExceptionMessage.INVALID_RACING_ATTEMPT_NUMBER)
        );
    }
}
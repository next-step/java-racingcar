package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingGameTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertDoesNotThrow(() -> {
            RacingGame racingGame = new RacingGame();
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"3:5", "5:4", "1:1"}, delimiter = ':')
    @DisplayName("게임 실행")
    void start(final String carInput, final String attemptInput) {
        assertDoesNotThrow(() -> {
            RacingGame racingGame = new RacingGame();
            racingGame.start(carInput, attemptInput);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"1:asd", "asd:2", "asd:asd", ":"}, delimiter = ':')
    @DisplayName("입력값이 정수가 아닌 경우")
    void start_error(final String carInput, final String attemptInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingGame racingGame = new RacingGame();
            racingGame.start(carInput, attemptInput);
        });
    }
}
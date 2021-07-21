package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleControllerTest {

    @ParameterizedTest
    @CsvSource(value = {"1:asd", "asd:2", "asd:asd", ":"}, delimiter = ':')
    @DisplayName("입력값이 정수가 아닌 경우")
    void start_error(final String carInput, final String attemptInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            ConsoleController consoleController = new ConsoleController();
            consoleController.consoleRacingGameStart(carInput, attemptInput);
        });
    }
}
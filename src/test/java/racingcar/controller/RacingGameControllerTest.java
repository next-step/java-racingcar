package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.dto.CarRequestDto;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingGameControllerTest {

    @ParameterizedTest
    @CsvSource(value = {"1:asd", "asd:2", "asd:asd", ":"}, delimiter = ':')
    @DisplayName("입력값이 정수가 아닌 경우")
    void start_error(final String carInput, final String attemptInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            CarRequestDto carRequestDto = new CarRequestDto(carInput, attemptInput);

            RacingGameController racingGameController = new RacingGameController();
            racingGameController.racingGameStart(carRequestDto);
        });
    }
}
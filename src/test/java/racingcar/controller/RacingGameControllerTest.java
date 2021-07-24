package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.dto.CarRequestDto;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingGameControllerTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,hounx:asd", "pobi:sd", "crong:"}, delimiter = ':')
    @DisplayName("시도 회수가 정수가 아닌 경우")
    void start_error(final String names, final String attemptInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            CarRequestDto carRequestDto = new CarRequestDto(names, attemptInput);

            RacingGameController racingGameController = new RacingGameController();
            racingGameController.racingGameStart(carRequestDto);
        });
    }
}
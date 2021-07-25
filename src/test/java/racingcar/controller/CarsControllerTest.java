package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.dto.CarRequestDto;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsControllerTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,hounx:asd", "pobi:sd", "crong:"}, delimiter = ':')
    @DisplayName("시도 회수가 정수가 아닌 경우")
    void startAttemptNumberInvalid(final String names, final String attemptInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            CarRequestDto carRequestDto = new CarRequestDto(names, attemptInput);

            RacingGameController racingGameController = new RacingGameController();
            racingGameController.racingGameStart(carRequestDto);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,cronga,hounx:asd", "pobiff:sd", "crongee:"}, delimiter = ':')
    @DisplayName("이름이 5글자가 넘을경우")
    void startNameLengthOver(final String names, final String attemptInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            CarRequestDto carRequestDto = new CarRequestDto(names, attemptInput);

            RacingGameController racingGameController = new RacingGameController();
            racingGameController.racingGameStart(carRequestDto);
        });
    }
}

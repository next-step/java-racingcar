package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.controller.CarRacingController;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RacingTest {

    @ParameterizedTest
    @CsvSource(value = {"-2, -1", "1, -1", "-3, 1"})
    @DisplayName("게임 시작시에 입력되는 변수는 양수여야만 한다")
    void racingTest_for_wrongInputValue(int numberOfCars, int numberOfTrys) {
        assertThatThrownBy(() -> new CarRacingController().racingGame(numberOfCars, numberOfTrys)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "2, 2", "3, 3"})
    @DisplayName("정상값에 대해서는 게임이 아무 이슈없이 잘 실행되어야 한다")
    void racingTest_for_rightInputValue(int numberOfCars, int numberOfTrys) {
        assertDoesNotThrow(() -> new CarRacingController().racingGame(numberOfCars, numberOfTrys));
    }
}

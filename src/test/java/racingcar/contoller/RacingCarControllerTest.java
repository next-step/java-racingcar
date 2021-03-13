package racingcar.contoller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Round;
import racingcar.dto.InputManagement;

import static org.assertj.core.api.Assertions.*;

class RacingCarControllerTest {

    @ParameterizedTest
    @CsvSource({"5, 5"})
    @DisplayName("주어진 횟수 동안 경주 게임을 진행할 수 있다.")
    void carsCanGoInGivenCount(int countRound, int finish) {
        InputManagement inputManagement = new InputManagement(null, countRound);

        RacingCarController racingCarController = new RacingCarController(null, inputManagement);

        Round round = new Round();
        while (racingCarController.hasNextRound(round)) {
            round.update();
        }

        assertThat(countRound).isEqualTo(finish);
    }
}
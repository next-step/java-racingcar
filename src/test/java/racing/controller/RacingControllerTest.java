package racing.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Turn;
import racing.domain.dto.GameRequest;
import racing.view.DosResultView;

import static org.assertj.core.api.Assertions.assertThat;

class RacingControllerTest {
    @CsvSource(value = {
            "A,B,C|10",
            "A,B,C,D,EEEF|10"
    }, delimiter = '|')
    @DisplayName("gameRun Test")
    @ParameterizedTest
    public void gameRunTest(String carNames, int turnSize) {
        GameRequest gameRequest = new GameRequest(carNames, turnSize);

        RacingController controller = new RacingController(new DosResultView());
        controller.gameRun(gameRequest);
    }
}
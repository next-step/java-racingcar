package racing.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.game.dto.GameRequest;
import racing.domain.game.vo.Turns;

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

        RacingController controller = new RacingController();
        Turns turns = controller.gameRun(gameRequest);

        assertThat(turns.size())
                .isEqualTo(turnSize);
    }
}
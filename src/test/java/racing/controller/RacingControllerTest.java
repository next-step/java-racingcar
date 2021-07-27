package racing.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.dto.GameRequest;
import racing.domain.dto.GameResponse;

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

        GameResponse gameResponse = RacingController.getInstance().gameRun(gameRequest);
        assertThat(gameResponse).isNotNull();
    }
}
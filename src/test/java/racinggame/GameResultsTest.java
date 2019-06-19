package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultsTest {
    @Test
    void 라운드_진행() {
        String carNameString = "pobi,crong,honux";
        GameResults gameResults = new GameResults();
        Cars cars = new Cars(carNameString);
        GameResult gameResult = new GameResult(cars);
        gameResults.getGameResults().add(gameResult);

        assertThat(gameResults.getGameResults().size()).isEqualTo(1);
    }
}

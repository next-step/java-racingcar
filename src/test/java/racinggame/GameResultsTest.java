package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultsTest {
    @Test
    void 라운드_진행() {
        String carNameString = "pobi,crong,honux";
        CarNames carNames = new CarNames(carNameString);

        GameResults gameResults = new GameResults();
        Cars cars = new Cars(carNames);
        GameResult gameResult = new GameResult(cars);
        gameResults.addResult(gameResult);

        assertThat(gameResults.getSize()).isEqualTo(1);
    }
}

package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameResultsTest {
    @Test
    void 생성자_정상() {
        GameResults gameResults = new GameResults();
        Assertions.assertThat(gameResults.getGameResultList().size()).isEqualTo(0);
    }

    @Test
    void 라운드_진행() {
        int carQuantity = 3;
        GameResults gameResults = new GameResults();
        Assertions.assertThat(gameResults.getGameResultList().size()).isEqualTo(0);

        CarLists carLists = new CarLists(carQuantity);
        GameResult gameResult = new GameResult(carLists);
        gameResults.addRoundResult(gameResult);

        Assertions.assertThat(gameResults.getGameResultList().size()).isEqualTo(1);
    }
}

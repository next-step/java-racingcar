package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultsTest {
    @Test
    void 생성자_정상() {
        GameResults gameResults = new GameResults();
        assertThat(gameResults.getGameResultList().size()).isEqualTo(0);
    }

    @Test
    void 라운드_진행() {
        int carQuantity = 3;
        GameResults gameResults = new GameResults();
        assertThat(gameResults.getGameResultList().size()).isEqualTo(0);

        CarLists carLists = new CarLists(carQuantity);
        GameResult gameResult = new GameResult(carLists);
        gameResults.addRoundResult(gameResult);

        assertThat(gameResults.getGameResultList().size()).isEqualTo(1);
    }
}

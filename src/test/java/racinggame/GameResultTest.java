package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private int carQuantity = 3;

    @Test
    void 생성자_정상() {
        CarLists carLists = new CarLists(carQuantity);
        GameResult gameResult = new GameResult(carLists);
        assertThat(gameResult.getGameResult().size()).isEqualTo(carQuantity);
    }
}

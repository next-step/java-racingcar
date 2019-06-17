package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameResultTest {
    private int carQuantity = 3;

    @Test
    void 생성자_정상() {
        CarLists carLists = new CarLists(carQuantity);
        GameResult gameResult = new GameResult(carLists);
        Assertions.assertThat(gameResult.getGameResult().size()).isEqualTo(carQuantity);
    }
}

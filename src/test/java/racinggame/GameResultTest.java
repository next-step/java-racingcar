package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private int carQuantity = 3;

    @Test
    void 생성자_정상() {
        Cars cars = new Cars(carQuantity);
        GameResult gameResult = new GameResult(cars);
        assertThat(gameResult.getGameResult().size()).isEqualTo(carQuantity);
    }
}

package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameResultsTest {
    @Test
    void 생성자_정상() {
        GameResults gameResults = new GameResults();
        Assertions.assertThat(gameResults.getGameResultList().size()).isEqualTo(0);
    }
}

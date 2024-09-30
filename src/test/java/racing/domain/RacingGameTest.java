package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @DisplayName("생성자를 통해 자동차 리스트와 전진 수를 잘 생성하는지")
    @Test
    void setUpTest() {
        RacingGame newGame = RacingGame.setUp(1, 5);
        assertThat(newGame.getRoundCount()).isEqualTo(1);
        assertThat(newGame.getCars()).hasSize(5);
    }
}

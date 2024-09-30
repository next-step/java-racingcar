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

    @DisplayName("게임이 시작되면 라운드 수 만큼의 결과 객체를 잘 반환하는지")
    @Test
    void startTest() {
        RacingGame newGame = RacingGame.setUp(1, 5);
        List<GameResult> results = newGame.start();
        assertThat(results).hasSize(1);
    }
}

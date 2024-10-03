package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameRoundsTest {

    @Test
    @DisplayName("getRoundCount 메서드가 게임 라운드 수를 반환한다.")
    void getRoundCountTest() {
        GameRounds gameRounds = initGameRounds();
        gameRounds.save(initGameResults());
        assertThat(gameRounds.getRoundCount()).isOne();
    }

    private GameRounds initGameRounds() {
        return new GameRounds();
    }

    private GameResults initGameResults() {
        List<String> carNames = List.of("자동차1", "자동차2", "자동차3");
        return new GameResults(new Cars(carNames));
    }

}
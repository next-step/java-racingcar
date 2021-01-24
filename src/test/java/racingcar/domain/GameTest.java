package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private MockCars mockCars;

    @BeforeEach()
    void setup() {
        mockCars = new MockCars(
            new ArrayList<>(),
            new TrueMoveChecker()
        );
    }

    @DisplayName("다음 라운드가 남아있는지를 확인")
    @Test
    void hasNextRoundRemained() {
        Game game = new Game(mockCars, 1);

        assertThat(game.hasNextRound()).isEqualTo(true);
    }

    @DisplayName("다음 라운드가 남아있는지 않은지를 확인")
    @Test
    void hasNextRoundNotRemained() {
        Game game = new Game(mockCars, 0);

        assertThat(game.hasNextRound()).isEqualTo(false);
    }

    @DisplayName("다음 라운드를 진행한 결과를 잘 가져오는지 확인")
    @Test
    void nextRound() {
        Game game = new Game(mockCars, 1);

        ResultRound resultRound = game.nextRound();

        assertThat(resultRound).isEqualTo(mockCars.getRound());
    }

    @DisplayName("승리자의 결과를 잘 가져오는지 확인")
   @Test
    void getResultWinners() {
        Game game = new Game(mockCars, 1);

        ResultWinners resultWinners = game.computeWinner();

        assertThat(resultWinners).isEqualTo(mockCars.getWinners());
    }
}

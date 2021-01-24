package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @DisplayName("게임 시작시 라운드 진행이 잘 되는지 확인")
    @Test
    void start() {
        MockCars mockCars = new MockCars(
            new ArrayList<>(),
            new TrueMoveChecker()
        );
        Game game = new Game(mockCars, 5);

        game.start();

        assertThat(5).isEqualTo(mockCars.doRoundCallCnt);
    }

    @DisplayName("게임 결과인 승자를 잘 가져오는지 확인")
    @Test
    void getResultWinners() {
        MockCars mockCars = new MockCars(
            new ArrayList<>(),
            new TrueMoveChecker()
        );
        Game game = new Game(mockCars, 5);

        ResultWinners result = game.getResultWinners();

        assertThat(result).isEqualTo(
            new ResultWinners(
                mockCars.getWinners()
            )
        );
    }
}

package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.RacingGame;
import racing.strategy.MoveStrategy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("경기 정보 받는 테스트")
    void racingGameInfo() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        int car = 5;
        int cycle = 10;
        RacingGame game = new RacingGame(car, cycle);
        game.info();
        assertThat(outContent.toString().trim()).isEqualTo("자동차 수: " + car + ", 사이클 수: " + cycle);
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("경기 시작하기 테스트")
    void racingGameStart() {
        int car = 5;
        int cycle = 3;
        RacingGame game = new RacingGame(car, cycle);
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(5);
        game.setMoveStrategyOfCars(moveStrategy);

        game.start();
        List<Integer> result = game.result();
        for (Integer integer : result) {
            assertThat(integer).isEqualTo(cycle);
        }
    }
}
package racing.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.FixedRandomForwardStrategy;
import racing.domain.RacingCar;
import racing.domain.RacingGame;
import racing.strategy.MoveStrategy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("자동차 사이클 진행 테스트")
    void printCycle() {
        RacingCar car = new RacingCar();
        int cycle = 3;
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(5);
        car.setMoveStrategy(moveStrategy);
        for (int i = 0; i < cycle; i++) {
            car.move();
        }
        ResultView.printCarStatus(car);
        assertThat(outContent.toString().trim()).isEqualTo("---");

    }

    @Test
    @DisplayName("자동차 경기 결과 테스트")
    void printResult() {
        int car = 3;
        int cycle = 3;
        RacingGame game = new RacingGame(car);
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(5);
        game.setMoveStrategyOfCars(moveStrategy);

        for (int i = 0; i < cycle; i++) {
            game.progressCycle();
        }

        ResultView.printGameStatus(game);
        assertThat(outContent.toString().trim()).isEqualTo("---\n---\n---");
    }
}
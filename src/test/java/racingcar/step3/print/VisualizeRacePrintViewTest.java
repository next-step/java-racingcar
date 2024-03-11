package racingcar.step3.print;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.Car;
import racingcar.step3.Round;
import racingcar.step3.move.IncrementMoveStrategy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VisualizeRacePrintViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("자동차의 위치를 '-'를 사용해 출력한다.")
    @Test
    void printCarLocationWithDash() {
        // given
        DashVisualizePrintStrategy printStrategy = new DashVisualizePrintStrategy();
        Round round = new Round(new IncrementMoveStrategy(), 3);

        // when
        round.startRound();
        round.startRound();

        // then
        assertThat(round.getCarsCurrentDistance()).containsExactly(2, 2, 2);
    }
}
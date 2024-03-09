package racingcar.step3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.move.IncrementMoveStrategy;
import racingcar.step3.print.DashVisualizePrintStrategy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private Round round;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("각 자동차의 현재 위치만큼 '-'를 출력한다.")
    @Test
    void printEachCarLocation() {
        // given
        round = new Round(new IncrementMoveStrategy(), 3, new DashVisualizePrintStrategy());

        // when
        round.startRound();
        round.startRound();
        round.startRound();
        round.printRoundResult();

        // then
        assertThat(output.toString().trim()).isEqualTo("---\n" + "---\n" + "---");
    }
}
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

class RacingCarContestTest {

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

    @DisplayName("정해진 값으로 레이싱을 돌리면, 정해진 값이 출력된다.")
    @Test
    void printRacingResult() {
        // given
        RacingCarContest racingCarContest = new RacingCarContest(
                3, 3, new IncrementMoveStrategy(), new DashVisualizePrintStrategy()
        );

        // when
        racingCarContest.startRacingContest();

        // then
        assertThat(output.toString().trim()).isEqualTo(
                "-\n" + "-\n" + "-\n\n" + "--\n" + "--\n" + "--\n\n" + "---\n" + "---\n" + "---"
        );
    }
}
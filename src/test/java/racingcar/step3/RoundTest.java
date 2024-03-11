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

    private Round round;

    @DisplayName("각 자동차의 현재 위치만큼 값을 리턴한다.")
    @Test
    void printEachCarLocation() {
        // given
        round = new Round(new IncrementMoveStrategy(), 3);

        // when
        round.startRound();
        round.startRound();
        round.startRound();

        // then
        assertThat(round.getCarsCurrentDistance()).containsExactly(3, 3, 3);
    }
}
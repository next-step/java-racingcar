package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.dto.RacingData;
import step2.dto.ResultData;
import step2.move.DefaultMove;
import step2.racing.Racing;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    private static Racing racing;
    private static ResultData resultData;

    @BeforeEach
    void setUp() {
        racing = new Racing(new RacingData(new String[]{"bus", "taxi", "tank"}, 5),
                new DefaultMove());
        resultData = racing.race();
    }

    @Test
    void findWinner() {
        String[] winners = resultData.findWinner().toString()
                .replace(" ", "")
                .split("[,]");
        assertThat(winners)
                .containsExactlyInAnyOrder("bus", "taxi", "tank");
    }

    @Test
    void scoreByTurn() {
        assertThat(resultData.scoreByTurn(0)).containsExactlyInAnyOrder(1, 1, 1);
        assertThat(resultData.scoreByTurn(1)).containsExactlyInAnyOrder(2, 2, 2);
        assertThat(resultData.scoreByTurn(2)).containsExactlyInAnyOrder(3, 3, 3);
        assertThat(resultData.scoreByTurn(3)).containsExactlyInAnyOrder(4, 4, 4);
        assertThat(resultData.scoreByTurn(4)).containsExactlyInAnyOrder(5, 5, 5);
    }


}
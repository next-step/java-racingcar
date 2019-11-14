package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void scoreByRound(int round) {
        assertThat(resultData.modelAndScoreByRound(round - 1).values())
                .containsExactlyInAnyOrder(round, round, round);
    }
}
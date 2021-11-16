package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnersTest {
    private final String RACER_ONE = "tomo";
    private final String RACER_TWO = "pobi";
    private final String RACER_THREE = "crone";

    private final List<String> winnerNames = Arrays.asList(RACER_ONE, RACER_TWO);
    private final int NUMBER_OF_WINNERS = 2;

    private Winners winners = new Winners(winnerNames);

    @Test
    void testSizeEqualTo() {
        assertThat(winners.sizeEqualTo(NUMBER_OF_WINNERS)).isTrue();
    }

    @Test
    void testContains() {
        assertThat(winners.contains(RACER_ONE)).isTrue();
        assertThat(winners.contains(RACER_TWO)).isTrue();
        assertThat(winners.contains(RACER_THREE)).isFalse();
    }
}

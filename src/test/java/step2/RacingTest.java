package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.dto.RacingData;
import step2.move.DefaultMove;
import step2.racing.Racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingTest {
    private static Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing(new RacingData(new String[]{"car1", "car2", "car3"}, 5),
                new DefaultMove());
    }

    @Test
    void moveTest() {
        assertAll(
                () -> assertThat(racing.scoreAfterMove(1, 0)).isEqualTo("-"),
                () -> assertThat(racing.scoreAfterMove(1, 1)).isEqualTo("--"),
                () -> assertThat(racing.scoreAfterMove(1, 2)).isEqualTo("---"),
                () -> assertThat(racing.scoreAfterMove(1, 3)).isEqualTo("----"),
                () -> assertThat(racing.scoreAfterMove(1, 4)).isEqualTo("-----")
        );
    }

}
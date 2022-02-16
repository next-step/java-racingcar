package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingTest {

    @Test
    void race() {
        Round round = new Round(1);
        Racing racing = new Racing(Arrays.asList(new Car("a", () -> true), new Car("b", () -> false)), round);

        racing.race();
        List<CarResult> lastRoundResult = round.getRacingResult().getLastRoundResult();

        assertAll(
            () -> assertThat(lastRoundResult.get(0).getName()).isEqualTo("a"),
            () -> assertThat(lastRoundResult.get(0).getDistance()).isEqualTo(1),
            () -> assertThat(lastRoundResult.get(1).getName()).isEqualTo("b"),
            () -> assertThat(lastRoundResult.get(1).getDistance()).isEqualTo(0)
        );
    }

}

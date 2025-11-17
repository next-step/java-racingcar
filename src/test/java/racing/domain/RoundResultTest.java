package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RoundResultTest {

    @Test
    void 한_라운드의_결과를_저장한다() {
        Cars cars = new Cars(3);
        cars.moveCars(() -> true);

        RoundResult roundResult = new RoundResult(cars);
        assertThat(roundResult.getRoundResult()).containsExactly(1, 1, 1);
    }
}

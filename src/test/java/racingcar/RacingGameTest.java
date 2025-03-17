package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingGameTest {

    @Test
    @DisplayName("자동차들이 최대 tryCount만큼 움직여야 한다")
    void process() {
        Cars carsForTest = Cars.of(List.of(
                Car.of("pobi"),
                Car.of("crong")
        ));
        int tryCount = 3;
        new RacingGame(carsForTest, tryCount, new ResultView()).process(new AlwaysMoveStrategy());
        Assertions.assertThat(carsForTest.getRaceStatusString()).contains("-".repeat(tryCount));
    }
}

package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("자동차 대수만큼 자동차가 만들어진다. (3 → 3대)")
    @Test
    public void test_1() {
        assertThat(new RacingGame(3, 0).getCarCount()).isEqualTo(3);
    }
}

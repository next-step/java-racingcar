package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domains.Racing;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    void isPlaying() {
        Racing racing = new Racing(3, 5);

        assertThat(racing.isPlaying()).isTrue();
    }

    @Test
    void racingIsEnd() {
        Racing racing = new Racing(3, 5, 5);

        assertThat(racing.isPlaying()).isFalse();
    }
}

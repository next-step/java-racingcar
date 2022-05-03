package racingCar.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @DisplayName("라운드가 진행 중일 경우 true 반환")
    @Test
    void isPlaying() {
        Racing racing = new Racing("pobi,crong,honux", 5);

        assertThat(racing.isPlaying()).isTrue();
    }

    @DisplayName("라운드가 끝났을 경우 false 반환")
    @Test
    void racingIsEnd() {
        Racing racing = new Racing("pobi,crong,honux", 5, 5);

        assertThat(racing.isPlaying()).isFalse();
    }
}

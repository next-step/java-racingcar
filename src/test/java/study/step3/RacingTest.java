package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @DisplayName("레이싱게임이 아직 끝나지 않음")
    @Test
    void isFinished() {
        Racing racing = Racing.of(Cars.of(5), 3);
        assertThat(racing.isFinshed()).isFalse();
    }
}

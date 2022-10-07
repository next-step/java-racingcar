package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    @Test
    @DisplayName("race 메소드는 파라미터로 들어온 횟수만큼 경주를 진행한다.")
    void race_result() {
        Racing racing = new Racing(3);
        racing.race(5);

        assertThat(racing.result()).hasSize(5);
    }
}
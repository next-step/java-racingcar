package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrialTest {

    @DisplayName("생성자 테스트")
    @Test
    void 생성자() {
        int expected = 5;
        Trial trial = new Trial(expected);

        assertThat(trial.getValue()).isEqualTo(expected);
    }
}
package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrialTest {

    @DisplayName("생성자 테스트")
    @Test
    void 생성자() {
        // given
        final String input = "5";
        final Trial trial = new Trial(input);

        // then
        assertThat(trial.getValue()).isEqualTo(5);
    }
}

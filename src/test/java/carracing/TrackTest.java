package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrackTest {
    @Test
    @DisplayName("Track getSteps() 테스트")
    void trackGetSteps() {
        Track track = new Track(5);
        List<Integer> steps = track.getSteps();

        assertThat(steps.size()).isEqualTo(5);
        for (int step : steps) {
            assertThat(step).isEqualTo(0);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10, 100, 999})
    @DisplayName("Track forward() 테스트")
    void trackForward(int round) {
        Track track = new Track(100);
        for (int i = 0; i < round; i++) {
            track.forward();
        }

        List<Integer> steps = track.getSteps();
        for (int step : steps) {
            assertThat(step).isGreaterThanOrEqualTo(0);
            assertThat(step).isLessThanOrEqualTo(round);
        }
    }
}
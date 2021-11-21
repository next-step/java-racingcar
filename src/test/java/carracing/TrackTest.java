package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrackTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10, 100, 999})
    @DisplayName("Track forward() 테스트")
    void trackForward(int round) {
        Track track = new Track(100);
        for (int i = 0; i < round; i++) {
            track.forward();
        }

        List<Track.Round> rounds = track.getRounds();
        Track.Round lastRound = rounds.get(rounds.size() - 1);

        List<Integer> steps = lastRound.getSteps();
        steps.forEach(step -> {
            assertThat(step).isGreaterThanOrEqualTo(0);
            assertThat(step).isLessThanOrEqualTo(round);
        });
    }
}
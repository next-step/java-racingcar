package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackTest {
    private static final List<String> carNames = List.of("pobi", "edu");

    @Test
    @DisplayName("생성/자동차N대 생성/생성된다.")
    void createTrack() {
        Track track = new Track(carNames);
        assertThat(track).isInstanceOf(Track.class);
    }

    @Test
    void run() {
        Track track = new Track(carNames);
        track.run();
    }
}

package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackTest {

    @Test
    @DisplayName("생성/자동차N대 이동횟수 생성/생성된다.")
    void createTrack() {
        Track track = new Track(10, 3);
        assertThat(track).isInstanceOf(Track.class);
    }

    @Test
    void run() {
        Track track = new Track(10, 3);
        track.run();
    }
}

package study.step5.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackTest {
    private Track track;

    @BeforeEach
    void setCar() {
        track = new Track("pobi,crong,honux", 5);
    }

    @Test
    void isRaceEnd() {
        for (int i = 0; i < 5; i++) {
            track.startRacing();
        }
        assertThat(track.isRaceEnd()).isEqualTo(true);
    }
}

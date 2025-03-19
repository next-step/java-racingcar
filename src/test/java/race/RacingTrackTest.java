package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTrackTest {
    @Test
    void valid_car_count() {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        assertThat(racingTrack.validateCarCount(5)).isTrue();
    }

    @Test
    void invalid_car_count() {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        assertThat(racingTrack.validateCarCount(0)).isFalse();
        assertThat(racingTrack.validateCarCount(15)).isFalse();
    }

    @Test
    void valid_attempt_count() {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        assertThat(racingTrack.validateAttemptCount(5)).isTrue();
    }

    @Test
    void invalid_attempt_count() {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        assertThat(racingTrack.validateAttemptCount(0)).isFalse();
        assertThat(racingTrack.validateAttemptCount(15)).isFalse();
    }
}

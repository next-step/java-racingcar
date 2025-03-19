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

    @Test
    void valid_car_names() {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        assertThat(racingTrack.validateCarNames(new String[]{"test1", "test2"})).isTrue();
    }

    @Test
    void invalid_car_names() {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        assertThat(racingTrack.validateCarNames(new String[]{"", "test2"})).isFalse();
        assertThat(racingTrack.validateCarNames(new String[]{"testtesttest", "test2"})).isFalse();
        assertThat(racingTrack.validateCarNames(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"})).isFalse();
    }
}

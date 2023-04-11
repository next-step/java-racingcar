package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrackTest {
    private Track track;

    @BeforeEach
    void setCar() {
        track = new Track(5, 5);
    }

    @Test
    void 레이싱_시작_테스트() {
        track.startRacing();
        List<Car> cars = track.getCars();
        for (Car car : cars) {
            assertThat(car.getAttemptCount()).isEqualTo(1);
        }
    }

    @Test
    void 마지막바퀴_치크() {
        for (int i = 0; i < 5; i++) {
            track.startRacing();
        }
        assertThat(track.isRaceEnd()).isEqualTo(true);
    }
}
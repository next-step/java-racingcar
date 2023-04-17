package study.step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TrackTest {
    private Track track;

    @BeforeEach
    void setCar() {
        track = new Track("pobi,crong,honux", 5);
    }

    @Test
    void 레이싱_시작_테스트() {
        track.startRacing();
        List<Car> cars = track.getWinnerCars();
        for (Car car : cars) {
            assertThat(car.getAttemptCount()).isEqualTo(1);
        }
    }

    @Test
    void 마지막바퀴_체크() {
        for (int i = 0; i < 5; i++) {
            track.startRacing();
        }
        assertThat(track.isRaceEnd()).isEqualTo(true);
    }

    @Test
    void 경기우승자() {
        track.startRacing();
        track.getWinnerCars();
        int winnerPosition = track.winnerPosition();
        List<Car> winnerCars = track.getCars();
        for (Car winnerCar : winnerCars) {
            assertThat(winnerCar.getPosition()).isEqualTo(winnerPosition);
        }
    }
}

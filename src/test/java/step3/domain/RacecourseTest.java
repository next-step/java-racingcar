package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.util.RacingCreateHelper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacecourseTest {

    private Racecourse racecourse;
    private List<Track> tracks;
    private List<RacingCar> racingCars;

    @BeforeEach
    void setUp() {
        tracks = RacingCreateHelper.createTracks(10);
        racingCars = RacingCreateHelper.createRacingCars(5);
        racecourse = new Racecourse(tracks);


        for (RacingCar racingCar : racingCars) {
            racecourse.enter(racingCar);
        }

    }

    @Test
    @DisplayName("racecourse에 racingCar를 입장시키면 racingCar가 track에 배정된다.")
    void entranceTest() {
        // given
        RacingCar racingCar = new RacingCar();

        // when
        racecourse.enter(racingCar);

        // then
        assertThat(racecourse.tracks()).map(Track::exit).contains(racingCar);
    }

    @Test
    @DisplayName("racecourse track에 빈 자리가 없으면 racingCar를 입장시킬 수 없다.")
    void overflowTest() {
        // given
        List<RacingCar> racingCars = RacingCreateHelper.createRacingCars(11);

        // when&then
        Assertions.assertThatThrownBy(() -> {
            for (RacingCar racingCar : racingCars) {
                racecourse.enter(racingCar);
            }
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("빈 track이 존재하지 않습니다.");
    }

    @Test
    @DisplayName("racecourse에서 전진 신호를 주면 0 또는 1칸만큼 전진한다.")
    void racingCarTest() {
        // given
        RacingCar racingCar = new RacingCar();
        racecourse.enter(racingCar);

        // when
        racecourse.signalToForward();
        racecourse.signalToForward();
        racecourse.signalToForward();

        // then
        assertThat(racingCar.position()).isBetween(0, 3);
    }

}
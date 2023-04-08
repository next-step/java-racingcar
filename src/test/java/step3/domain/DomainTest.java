package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.util.RacingCreateHelper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainTest {

    private Racecourse racecourse;
    private List<Track> tracks;
    private List<RacingCar> racingCars;

    @BeforeEach
    void setUp() {
        racecourse = new Racecourse();
        tracks = RacingCreateHelper.createTracks(10);
        racingCars = RacingCreateHelper.createRacingCars(5);

        racecourse.addTracks(tracks);

        for (RacingCar racingCar : racingCars) {
            racecourse.entrance(racingCar);
        }

    }

    @Test
    @DisplayName("racecourse에 track을 추가하면 track을 정렬한다.")
    void trackTest() {
        // given
        Track track = new Track(0);

        // when
        racecourse.addTrack(track);

        // then
        assertThat(racecourse.tracks()).isSorted();
    }

    @Test
    @DisplayName("racingCar가 전진을 시도하면 0 또는 1칸만큼 전진한다.")
    void racingCarTest() {
        // given
        RacingCar racingCar = new RacingCar();
        racecourse.entrance(racingCar);

        // when
        racecourse.signalToForward();
        racecourse.signalToForward();
        racecourse.signalToForward();

        // then
        assertThat(racingCar.position()).isBetween(0, 3);
    }

    @Test
    @DisplayName("racecourse에 racingCar를 입장시키면 racingCar가 track에 배정된다.")
    void entranceTest() {
        // given
        RacingCar racingCar = new RacingCar();

        // when
        racecourse.entrance(racingCar);

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
                racecourse.entrance(racingCar);
            }
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("빈 track이 존재하지 않습니다.");
    }

    @Test
    @DisplayName("track에 racingCar가 없으면 빈 track이다.")
    void emptyTrackTest() {
        // given
        Track track = new Track(0);

        // when
        racecourse.addTrack(track);

        // then
        assertThat(track.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("track에 racingCar가 있으면 빈 track이 아니다.")
    void notEmptyTrackTest() {
        // given
        Track track = new Track(0);

        // when
        track.entrance(new RacingCar());

        // then
        assertThat(track.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("track에 racingCar가 있으면 racingCar를 퇴장시킬 수 있다.")
    void exitTest() {
        // given
        Track track = new Track(0);
        RacingCar racingCar = new RacingCar();
        track.entrance(racingCar);

        // when
        track.exit();

        // then
        assertThat(track.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("track에 racingCar가 없으면 위치를 확인할 수 없다.")
    void emptyTrackPositionTest() {
        // given
        Track track = new Track(0);

        // when&then
        Assertions.assertThatThrownBy(track::carPosition)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("해당 track에는 car가 존재하지 않습니다.");
    }

    @Test
    @DisplayName("track에 racingCar가 있으면 위치를 확인할 수 있다.")
    void notEmptyTrackPositionTest() {
        // given
        Track track = new Track(0);
        RacingCar racingCar = new RacingCar();
        track.entrance(racingCar);

        // when & then
        assertThat(track.carPosition()).isEqualTo(racingCar.position());
    }
}

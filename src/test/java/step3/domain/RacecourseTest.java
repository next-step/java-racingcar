package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.move.AbsoluteMoveStrategy;
import step3.move.StopMoveStrategy;
import step3.util.RacingCreateHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacecourseTest {

    private Racecourse racecourse;
    private List<Track> tracks;
    private List<RacingCar> racingCars;

    @BeforeEach
    void setUp() {
        tracks = RacingCreateHelper.createTracks(10);
        racingCars = RacingCreateHelper.createRacingCars(Arrays.asList("o1", "o2", "o3", "o4", "o5"));
        racecourse = new Racecourse(tracks);


        for (RacingCar racingCar : racingCars) {
            racecourse.enter(racingCar);
        }

    }

    @Test
    @DisplayName("racecourse에 racingCar를 입장시키면 racingCar가 track에 배정된다.")
    void entranceTest() {
        // given
        RacingCar racingCar = new RacingCar("mycar");

        // when
        racecourse.enter(racingCar);

        // then
        assertThat(racecourse.tracks()).map(Track::exit).contains(racingCar);
    }

    @Test
    @DisplayName("racecourse track에 빈 자리가 없으면 racingCar를 입장시킬 수 없다.")
    void overflowTest() {
        // given
        List<RacingCar> racingCars = RacingCreateHelper.createRacingCars(Arrays.asList("o1", "o2", "o3", "o4", "o5", "o6", "o7", "o8", "o9", "o10", "o11"));

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
        RacingCar racingCar = new RacingCar("mycar");
        racecourse.enter(racingCar);

        // when
        racecourse.signalToForward();
        racecourse.signalToForward();
        racecourse.signalToForward();

        // then
        assertThat(racingCar.position()).isBetween(0, 3);
    }

    @Test
    @DisplayName("자동차 없이 1순위 랭킹을 조회할 경우 조회되지 않는다.")
    void rankingTest() {
        // given
        Racecourse emptyCourse = new Racecourse(Collections.emptyList());

        // when
        List<RacingCar> topRank = emptyCourse.findTopRank();

        // then
        assertThat(topRank).isEmpty();
    }

    @Test
    @DisplayName("가장 많은 거리를 이동한 자동차가 랭킹 1등으로 조회된다")
    public void findRankingTest() {
        // given
        List<Track> customTrack = RacingCreateHelper.createTracks(3);
        Racecourse customCourse = new Racecourse(customTrack);
        final RacingCar top = new RacingCar("top", new AbsoluteMoveStrategy());
        final RacingCar o1 = new RacingCar("o1", new StopMoveStrategy());
        final RacingCar o2 = new RacingCar("o2", new StopMoveStrategy());

        customCourse.enter(top);
        customCourse.enter(o1);
        customCourse.enter(o2);

        // when
        customCourse.signalToForward();

        // then
        List<RacingCar> topRank = customCourse.findTopRank();
        assertThat(topRank).hasSize(1);
        assertThat(topRank).containsExactly(top);
    }

    @Test
    @DisplayName("가장 많은 거리를 이동한 자동차가 동시에 여러대일 경우 동시에 랭킹 1등으로 조회된다")
    public void findMultiRankingTest() {
        // given
        List<Track> customTrack = RacingCreateHelper.createTracks(3);
        Racecourse customCourse = new Racecourse(customTrack);
        final RacingCar top = new RacingCar("top", new AbsoluteMoveStrategy());
        final RacingCar top2 = new RacingCar("top2", new AbsoluteMoveStrategy());
        final RacingCar o1 = new RacingCar("o1", new StopMoveStrategy());

        customCourse.enter(top);
        customCourse.enter(top2);
        customCourse.enter(o1);

        // when
        customCourse.signalToForward();

        // then
        List<RacingCar> topRank = customCourse.findTopRank();
        assertThat(topRank).hasSize(2);
        assertThat(topRank).containsExactly(top, top2);
    }
}

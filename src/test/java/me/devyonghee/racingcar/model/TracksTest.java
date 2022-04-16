package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.model.sample.RacingCarSample;
import me.devyonghee.racingcar.model.sample.TrackSample;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("경주로들")
class TracksTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Tracks.from(Collections.singletonList(TrackSample.TRACK_AT_ZERO)));
    }

    @Test
    @DisplayName("컬렉션은 필수")
    void instance_emptyCollection_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Tracks.from(Collections.emptyList()));
        assertThatIllegalArgumentException().isThrownBy(() -> Tracks.from(null));
    }

    @Test
    @DisplayName("주어진 리스트 그대로 반환")
    void list() {
        //given
        List<Track> trackList = Collections.singletonList(TrackSample.TRACK_AT_ZERO);
        //when, then
        assertThat(Tracks.from(trackList).list()).containsExactlyElementsOf(trackList);
    }

    @Test
    @DisplayName("주어진 리스트 동일한 크기 반환")
    void size() {
        //given
        List<Track> twoTrackList = Arrays.asList(TrackSample.TRACK_AT_ZERO, TrackSample.TRACK_AT_ZERO);
        //when, then
        assertThat(Tracks.from(twoTrackList).size()).isEqualTo(twoTrackList.size());
    }

    @Test
    @DisplayName("다음 단계를 진행하면 동일한 수량의 track 이 생성")
    void movedTracks() {
        //given, when
        Tracks nextCycle = Tracks.from(Collections.singletonList(TrackSample.TRACK_AT_ZERO)).movedTracks();
        //then
        assertThat(nextCycle.size()).isOne();
    }

    @Test
    @DisplayName("가장 멀리간 하나의 트랙")
    void farthestTracks_single() {
        //given
        Track trackAtZero = Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.ZERO);
        Track trackAtOne = Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.ONE);
        //when
        Tracks farthestTracks = Tracks.from(Arrays.asList(trackAtOne, trackAtZero)).farthestTracks();
        //then
        assertThat(farthestTracks.list())
                .containsExactly(trackAtOne);
    }

    @Test
    @DisplayName("가장 멀리간 트랙들")
    void farthestTracks_multiple() {
        //given
        Track trackAtZero = Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.ZERO);
        Track trackAtOne1 = Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.ONE);
        Track trackAtOne2 = Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.ONE);
        //when
        Tracks farthestTracks = Tracks.from(Arrays.asList(trackAtZero, trackAtOne1, trackAtOne2)).farthestTracks();
        //then
        assertThat(farthestTracks.list())
                .containsExactly(trackAtOne1, trackAtOne2);
    }
}

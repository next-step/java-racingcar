package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.model.sample.RacingCarSample;
import me.devyonghee.racingcar.model.sample.TrackSample;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("경주로들 기록")
class TracksHistoryTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> TracksHistory.from(Collections.singletonList(
                Tracks.from(Collections.singletonList(TrackSample.TRACK_AT_ZERO)))));
    }

    @Test
    @DisplayName("컬렉션은 필수")
    void instance_emptyCollection_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> TracksHistory.from(null));
        assertThatIllegalArgumentException().isThrownBy(() -> TracksHistory.from(Collections.emptyList()));
    }

    @Test
    @DisplayName("주어진 리스트 그대로 반환")
    void list() {
        //given
        List<Tracks> tracksGroup = Collections.singletonList(Tracks.from(Collections.singletonList(Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.ZERO))));
        //when, then
        assertThat(TracksHistory.from(tracksGroup).list()).containsExactlyElementsOf(tracksGroup);
    }

    @Test
    @DisplayName("마지막 기록에서 가장 멀리간 트랙들")
    void lastFarthestTracks() {
        //given
        Track previousHistory = Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.ZERO);
        Track lastHistory = Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.ONE);
        //when
        Tracks lastFarthestTracks = TracksHistory.from(Arrays.asList(
                Tracks.from(Collections.singletonList(previousHistory)),
                Tracks.from(Collections.singletonList(lastHistory))
        )).lastFarthestTracks();
        //then
        assertThat(lastFarthestTracks.list())
                .containsExactly(lastHistory);
    }
}

package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@DisplayName("경주로들")
class TracksTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Tracks.from(Collections.emptyList()));
        assertThatNoException().isThrownBy(() -> Tracks.from(Collections.singletonList(TrackTest.TRACK_AT_ZERO)));
    }

    @Test
    @DisplayName("컬렉션은 필수")
    void instance_nullCollection_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Tracks.from(null));
    }

    @Test
    @DisplayName("다음 단계를 진행하면 동일한 수량의 track 이 생성")
    void movedTracks() {
        //given, when
        Tracks nextCycle = Tracks.from(Collections.singletonList(TrackTest.TRACK_AT_ZERO)).movedTracks();
        //then
        assertThat(nextCycle.size()).isOne();
    }
}

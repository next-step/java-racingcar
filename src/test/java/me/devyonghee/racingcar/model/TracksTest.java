package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.model.sample.RandomEngineSample;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("경주로들")
class TracksTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Tracks.from(Collections.emptyList()));
    }

    @Test
    @DisplayName("컬렉션은 필수")
    void instance_nullCollection_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Tracks.from(null));
    }

    @Test
    @DisplayName("다음 단계를 진행하면 동일한 수량의 track 이 생성")
    void movedTracks() {
        //given
        List<Track> tracks = Collections.singletonList(Track.of(RacingCar.from(RandomEngineSample.TEM_LIMIT_RANDOM_ENGINE), Distance.ZERO));
        //when
        Tracks nextCycle = Tracks.from(tracks).movedTracks();
        //then
        assertThat(nextCycle.size()).isEqualTo(1);
    }
}

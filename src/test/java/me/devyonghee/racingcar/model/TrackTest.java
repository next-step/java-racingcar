package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("경주로")
class TrackTest {

    public static final Track TRACK_AT_ZERO = Track.of(RacingCar.from(new MovementPolicy.Fake(true)), Distance.ZERO);

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Track.of(RacingCar.from(new MovementPolicy.Fake(true)), Distance.ZERO));
    }

    @Test
    @DisplayName("자동차, 거리는 필수")
    void instance_nullArgument_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Track.of(null, Distance.ZERO));
        assertThatIllegalArgumentException().isThrownBy(() -> Track.of(RacingCar.from(new MovementPolicy.Fake(true)), null));
    }

    @Test
    @DisplayName("다음 단계에서 자동차가 움직이면 거리는 증가")
    void movedTrack_move_increaseDistance() {
        //given, when
        Track track = Track.of(RacingCar.from(new MovementPolicy.Fake(true)), Distance.ZERO).movedTrack();
        //then
        assertThat(track.distance()).isEqualTo(Distance.ONE);
    }

    @Test
    @DisplayName("다음 단계에서 자동차가 움직이지 않으면 거리는 고정")
    void movedTrack_stop_sameDistance() {
        //given
        Distance initialDistance = Distance.ZERO;
        //when
        Track track = Track.of(RacingCar.from(new MovementPolicy.Fake(false)), initialDistance).movedTrack();
        //then
        assertThat(track.distance()).isEqualTo(initialDistance);
    }
}

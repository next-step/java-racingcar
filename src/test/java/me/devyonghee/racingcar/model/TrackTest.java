package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.model.sample.RacingCarSample;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("경주로")
class TrackTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Track.of(RacingCar.from(CarName.from("abc"), () -> Movement.MOVE), Distance.ZERO));
    }

    @Test
    @DisplayName("자동차, 거리는 필수")
    void instance_nullArgument_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Track.of(null, Distance.ZERO));
        assertThatIllegalArgumentException().isThrownBy(() -> Track.of(RacingCar.from(CarName.from("abc"), () -> Movement.MOVE), null));
    }

    @Test
    @DisplayName("주어진 자동차는 동일한 자동차로 반환")
    void car() {
        assertThat(Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.ZERO).car()).isEqualTo(RacingCarSample.ONLY_MOVE_CAR);
    }

    @Test
    @DisplayName("주어진 거리는 동일한 거리로 반환")
    void distance() {
        assertThat(Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.ZERO).distance()).isEqualTo(Distance.ZERO);
    }

    @Test
    @DisplayName("다음 단계에서 자동차가 움직이면 거리는 증가")
    void movedTrack_move_increaseDistance() {
        //given, when
        Track track = Track.of(RacingCar.from(CarName.from("abc"), () -> Movement.MOVE), Distance.ZERO).movedTrack();
        //then
        assertThat(track.distance()).isEqualTo(Distance.ONE);
    }

    @Test
    @DisplayName("다음 단계에서 자동차가 움직이지 않으면 거리는 고정")
    void movedTrack_stop_sameDistance() {
        //given
        Distance initialDistance = Distance.ZERO;
        //when
        Track track = Track.of(RacingCar.from(CarName.from("abc"), () -> Movement.STOP), initialDistance).movedTrack();
        //then
        assertThat(track.distance()).isEqualTo(initialDistance);
    }

    @ParameterizedTest
    @DisplayName("1 거리의 트랙 보다 더 큰지 여부")
    @CsvSource({"0,true", "1,false", "2,false"})
    void distanceGreaterThan(int distance, boolean expected) {
        //given, when
        boolean greaterThan = Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.ONE)
                .distanceGreaterThan(Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.from(distance)));
        //then
        assertThat(greaterThan).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("1 거리와 동일 여부")
    @CsvSource({"0,false", "1,true"})
    void equalDistance(int distance, boolean expected) {
        //given, when
        boolean equalDistance = Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.ONE)
                .equalDistance(Track.of(RacingCarSample.ONLY_MOVE_CAR, Distance.from(distance)));
        //then
        assertThat(equalDistance).isEqualTo(expected);
    }
}

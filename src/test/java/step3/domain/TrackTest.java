package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrackTest {

    @Test
    @DisplayName("track에 racingCar가 있으면 빈 track이 아니다.")
    void notEmptyTrackTest() {
        // given
        Track track = new Track(0);

        // when
        track.enter(new RacingCar("mycar"));

        // then
        assertThat(track.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("track에 racingCar가 있으면 racingCar를 퇴장시킬 수 있다.")
    void exitTest() {
        // given
        Track track = new Track(0);
        RacingCar racingCar = new RacingCar("mycar");
        track.enter(racingCar);

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
        RacingCar racingCar = new RacingCar("mycar");
        track.enter(racingCar);

        // when & then
        assertThat(track.carPosition()).isEqualTo(racingCar.position());
    }

}

package study03;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class RacingCarTest {

    @Test
    void Test01_자동차생성테스트() {
        RacingCar racingCar = new RacingCar();

        assertThat(racingCar.toString()).isEqualTo("자동차");
    }

    @Test
    void Test02_트랙생성테스트() {
        Track track1 = new Track(5);
        Track track2 = new Track(10);

        assertThat(track1.getTotalTrack()).isEqualTo("-----");
        assertThat(track2.getTotalTrack()).isEqualTo("----------");
    }

    @Test
    void Test03_엔진생성테스트() {
        Engine engine = new Engine();

        assertThat(engine.isFixedRun(3)).isFalse();
        assertThat(engine.isFixedRun(5)).isTrue();
        assertThat(engine.isFixedRun(7)).isTrue();
        assertThat(engine.isFixedRun(0)).isFalse();
    }

    @Test
    void Test04_자동차이동구현() {
        Track track = new Track(5);
        RacingCar racingCar = new RacingCar();
        track.addRacingCar(racingCar);

        racingCar.fixedMove(3);
        assertThat(track.tracking(0)).isEqualTo("-");
        racingCar.fixedMove(5);
        assertThat(track.tracking(0)).isEqualTo("--");
        racingCar.fixedMove(9);
        assertThat(track.tracking(0)).isEqualTo("---");
        racingCar.fixedMove(2);
        assertThat(track.tracking(0)).isEqualTo("---");
        racingCar.fixedMove(0);
        assertThat(track.tracking(0)).isEqualTo("---");
        racingCar.fixedMove(4);
        assertThat(track.trackingAll()).isEqualTo("----");
    }

    @Test
    void Test05_n대의자동차구현() {
        Track track = new Track(5);
        RacingCar racingCar1 = new RacingCar();
        RacingCar racingCar2 = new RacingCar();
        RacingCar racingCar3 = new RacingCar();

        track.addRacingCar(racingCar1);
        track.addRacingCar(racingCar2);
        track.addRacingCar(racingCar3);

        assertThat(track.tracking(0)).isEqualTo("-");
        assertThat(track.tracking(1)).isEqualTo("-");
        assertThat(track.tracking(2)).isEqualTo("-");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> track.tracking(3));
    }

    @Test
    void Test06_n대의자동차이동() {
        Track track = new Track(5);
        RacingCar racingCar1 = new RacingCar();
        RacingCar racingCar2 = new RacingCar();
        RacingCar racingCar3 = new RacingCar();

        track.addRacingCar(racingCar1);
        track.addRacingCar(racingCar2);
        track.addRacingCar(racingCar3);

        track.fixedMoveAll(new int[]{3, 5, 1});
        assertThat(track.trackingAll()).isEqualTo("-\n" +
                "--\n" +
                "-");
        track.fixedMoveAll(new int[]{9, 0, 6});
        assertThat(track.trackingAll()).isEqualTo("--\n" +
                "--\n" +
                "--");
        track.fixedMoveAll(new int[]{4, 4, 2});
        assertThat(track.trackingAll()).isEqualTo("---\n" +
                "---\n" +
                "--");
        track.fixedMoveAll(new int[]{7, 3, 3});
        assertThat(track.trackingAll()).isEqualTo("----\n" +
                "---\n" +
                "--");
    }
}

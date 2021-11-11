package study03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class RacingCarTest {

    private Track track;

    @BeforeEach
    void trackSetting() {
        track = new Track(5);
    }

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
        RacingCar racingCar = new RacingCar();

        racingCar.fixedMove(3);
        assertThat(racingCar.tracking(track)).isEqualTo("-");
        racingCar.fixedMove(5);
        assertThat(racingCar.tracking(track)).isEqualTo("--");
        racingCar.fixedMove(9);
        assertThat(racingCar.tracking(track)).isEqualTo("---");
        racingCar.fixedMove(2);
        assertThat(racingCar.tracking(track)).isEqualTo("---");
        racingCar.fixedMove(0);
        assertThat(racingCar.tracking(track)).isEqualTo("---");
        racingCar.fixedMove(4);
        assertThat(racingCar.tracking(track)).isEqualTo("----");
    }
}

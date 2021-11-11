package study03;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

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
}

package study03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TrackTest {

    @Test
    @DisplayName("Test01 - 트랙 초기화 및 자동차 추가 테스트")
    public void test01() {
        Track track = new Track();
        assertThat(track.trackingAll().size()).isEqualTo(0);

        track.addRacingCar(5);
        assertThat(track.trackingAll().size()).isEqualTo(5);

        track.addRacingCar();
        track.addRacingCar();
        assertThat(track.trackingAll().size()).isEqualTo(7);
    }

    @Test
    @DisplayName("Test02 - 자동차 이동 거리 얻기 테스트")
    public void test02() {
        Track track = new Track();
        track.addRacingCar(5);

        track.trackingAll().forEach(it -> assertThat(it).isEqualTo("-"));
    }

    @Test
    @DisplayName("Test03 - 트랙 내 모든 자동차 이동 테스트")
    public void test03() {
        Track track = new Track();
        track.addRacingCar(5);

        StringBuffer[] assertResult = new StringBuffer[] {new StringBuffer("-"),
                new StringBuffer("-"),
                new StringBuffer("-"),
                new StringBuffer("-"),
                new StringBuffer("-")};

        IntStream.range(0, 100).forEach(i -> {
            List<Boolean> moveList = track.moveAll();
            IntStream.range(0, 4).forEach(j -> {
                if (moveList.get(j)) {
                    assertResult[j].append("-");
                }
                System.out.println(assertResult[j]);
                List<String> tracking = track.trackingAll();
                assertThat(assertResult[j].toString()).isEqualTo(tracking.get(j));
            });
        });
    }

}

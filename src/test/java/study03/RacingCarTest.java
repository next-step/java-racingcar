package study03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import study03.racing.car.Distance;
import study03.racing.car.Engine;
import study03.racing.car.RacingCar;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class RacingCarTest {

    @Test
    @DisplayName("Test01_자동차생성테스트 - 자동차가 정상적으로 생성되는지 테스트")
    void Test01_자동차생성테스트() {
        RacingCar racingCar = new RacingCar();

        assertThat(racingCar.toString()).isEqualTo("자동차 (주행상태:-)");
    }

    @Test
    @DisplayName("Test02_엔진생성테스트 - 자동차가 엔진 객체 구동 테스트")
    void Test02_엔진생성테스트() {
        Engine engine = new Engine();

        IntStream.range(0, 100).forEach(i -> {
            boolean run = engine.isRun();
            if (run) {
                assertThat(run).isTrue();
            } else {
                assertThat(run).isFalse();
            }
        });
    }

    @Test
    @DisplayName("Test03_이동거리구현")
    void Test03_이동거리구현() {
        Distance distance = new Distance(1);

        assertThat(distance.totalMoved()).isEqualTo("-");
        distance.addDistance();
        distance.addDistance();
        assertThat(distance.totalMoved()).isEqualTo("---");
    }

    @Test
    @DisplayName("Test04_자동차이동구현")
    void Test04_자동차이동구현() {
        RacingCar racingCar = new RacingCar();
        StringBuffer assertResult = new StringBuffer("-");

        IntStream.range(0, 100).forEach(i -> {
            boolean move = racingCar.move();
            if (move) {
                assertResult.append("-");
            }
            assertThat(assertResult.toString()).isEqualTo(racingCar.currentMoveDistance());
        });
    }

}

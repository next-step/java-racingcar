package study04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class RacingCarTest {

    @ParameterizedTest
    @DisplayName("테스트01 - 이름이 지정된 자동차 생성 테스트")
    @ValueSource(strings = {"Uzu", "Bada"})
    void test01(String strings) {
        RacingCar racingCar = RacingCar.createRacingCar(strings);

        assertThat(racingCar.toString()).isEqualTo(String.format("[%s] 자동차 (주행거리:%s)", strings, 1));
    }

    @Test
    @DisplayName("테스트02 - 커스텀 엔진을 장착한 자동차 생성 테스트")
    void test02() {
        Engine hyperEngine = Engine.createEngine(10, 8);
        RacingCar supercar = RacingCar.createRacingCar("supercar", hyperEngine, Distance.createDistance());

        assertThat(supercar.toString()).isEqualTo("[supercar] 자동차 (주행거리:1)");
    }

    @Test
    @DisplayName("테스트03 - 자동차 주행 테스트")
    void test03() {
        Engine engine = Engine.createEngine();
        Distance distance = Distance.createDistance();
        RacingCar racingCar = RacingCar.createRacingCar("Test03Car", engine, distance);

        int resultMoveDistance = 1;

        for (int i = 0; i < 100; i++) {
            racingCar.move();
            if (engine.isLastedRun()) {
                resultMoveDistance++;
            }
            assertThat(resultMoveDistance).isEqualTo(racingCar.currentMoveDistance());
        }
    }
}

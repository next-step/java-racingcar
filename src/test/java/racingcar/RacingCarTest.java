package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    @DisplayName("차량을 생성하면 position이 0입니다.")
    void newRacingCarPositionTest() {
        RacingCar newCar = RacingCar.createWithCarNo(0);
        Assertions.assertEquals(0, newCar.getCarNo());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("차량을 생성할 때 지정된 carNo를 가집니다.")
    void newRacingCarCarNoTest(int carNo) {
        RacingCar newCar = RacingCar.createWithCarNo(carNo);
        Assertions.assertEquals(carNo, newCar.getCarNo());
    }

    @Test
    @DisplayName("race 이후에 position 이 단조증가합니다.")
    void raceMonotoneIncrementTest() {
        RacingCar car = RacingCar.createWithCarNo(0);
        int testWrapCount = 20;
        for (int i = 0; i < testWrapCount; i++) {
            int beforePosition = car.getPosition();
            car.race();
            int afterPosition = car.getPosition();
            assertThat(afterPosition).isGreaterThanOrEqualTo(beforePosition);
        }
    }

    @Test
    @DisplayName("race 이후에 position은 최대 1 증가합니다.")
    void racePositionIncrementByMaximumOneTest() {
        RacingCar car = RacingCar.createWithCarNo(0);
        int testWrapCount = 200;
        for (int i = 0; i < testWrapCount; i++) {
            int beforePosition = car.getPosition();
            car.race();
            int afterPosition = car.getPosition();
            assertThat(afterPosition).isLessThanOrEqualTo(beforePosition + 1);
        }
    }

    @Test
    @DisplayName("race 이후에 position은 60프로 확률로 증가합니다")
    void racePositionIncrementsWith60PercentChanceTest() {
        RacingCar car = RacingCar.createWithCarNo(0);
        int beforePosition = car.getPosition();
        int testWrapCount = 1000;
        for (int i = 0; i < testWrapCount; i++) {
            car.race();
        }

        int afterPosition = car.getPosition();
        int expectedMeanPosition = beforePosition + 600;
        int sigma = 15; // square root of 600 * (1-0.6)

        // 6시그마 범위 안에 있는지 확인 (100만분의 1 확률로 벗어날 수 있음)
        assertThat(afterPosition).isLessThanOrEqualTo(expectedMeanPosition + 6 * sigma);
        assertThat(afterPosition).isGreaterThanOrEqualTo(expectedMeanPosition - 6 * sigma);
    }
}

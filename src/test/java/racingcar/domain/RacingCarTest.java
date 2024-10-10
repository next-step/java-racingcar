package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private static final String DEFAULT_CAR_NAME = "car1";

    @Test
    @DisplayName("차량을 생성하면 position이 0입니다.")
    void newRacingCarPositionTest() {
        RacingCar newCar = RacingCar.valueOf(DEFAULT_CAR_NAME, 0);
        assertThat(newCar.getCarNo()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("차량을 생성할 때 지정된 carNo를 가집니다.")
    void newRacingCarCarNoTest(int carNo) {
        RacingCar newCar = RacingCar.valueOf(DEFAULT_CAR_NAME, carNo);
        assertThat(newCar.getCarNo()).isEqualTo(carNo);
    }

    @Test
    @DisplayName("race 시에 movableStrategy 가 true면 전진한다")
    void raceForwardTest() {
        RacingCar car = RacingCar.valueOf(DEFAULT_CAR_NAME, 0);
        int beforePosition = car.getPosition();
        car.race(() -> true);
        int afterPosition = car.getPosition();
        assertThat(afterPosition).isEqualTo(beforePosition + 1);
    }

    @Test
    @DisplayName("race 시에 movableStrategy 가 false면 전진하지 않는다")
    void raceStayTest() {
        RacingCar car = RacingCar.valueOf(DEFAULT_CAR_NAME, 0);
        int beforePosition = car.getPosition();
        car.race(() -> false);
        int afterPosition = car.getPosition();
        assertThat(afterPosition).isEqualTo(beforePosition);
    }
}

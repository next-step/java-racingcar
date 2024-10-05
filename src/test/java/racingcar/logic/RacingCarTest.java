package racingcar.logic;

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
    @DisplayName("race 시에 movableStrategy 가 true면 전진한다")
    void raceForwardTest() {
        RacingCar car = RacingCar.createWithCarNo(0);
        int beforePosition = car.getPosition();
        car.race(() -> true);
        int afterPosition = car.getPosition();
        assertThat(afterPosition).isEqualTo(beforePosition + 1);
    }

    @Test
    @DisplayName("race 시에 movableStrategy 가 false면 전진하지 않는다")
    void raceStayTest() {
        RacingCar car = RacingCar.createWithCarNo(0);
        int beforePosition = car.getPosition();
        car.race(() -> false);
        int afterPosition = car.getPosition();
        assertThat(afterPosition).isEqualTo(beforePosition);
    }
}

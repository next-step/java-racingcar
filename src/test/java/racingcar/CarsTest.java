package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("가장 많이 전진한 자동차가 우승하는지 확인한다.")
    public void GetWinner() {
        Cars cars = new Cars("car1,car2,car3");
        Cars.getCarList().get(0).move(4);

        assertThat(cars.getWinners()).isEqualTo("car1");
    }
}

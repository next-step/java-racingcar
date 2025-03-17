import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingMangerTest {

    @Test
    @DisplayName("통합 테스트")
    void integration() {
        final int carNum = 3;
        final int tryNum = 5;
        final RacingManger racingManger = new RacingManger(carNum);
        for (int i = 0; i < tryNum; i++) {
            racingManger.play();
        }
        final Car[] resultCar = racingManger.getCars();

        assertThat(resultCar.length).isEqualTo(carNum);
        for (Car car : resultCar) {
            assertThat(car.getPosition()).isBetween(0, tryNum);
        }
    }

    @Test
    void makeCars() {
        final int carNum = 3;
        final RacingManger racingManger = new RacingManger(carNum);
        final Car[] cars = racingManger.getCars();

        assertThat(cars.length).isEqualTo(carNum);
        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}

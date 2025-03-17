import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingMangerTest {

    @Test
    void forward() {
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
}

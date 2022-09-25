import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    @Test
    void moveAllCarsTest() {
        int expected = 1;

        CarRacing carRacing = new CarRacing(5, 2);
        carRacing.moveAllCar();

        for (Car car : carRacing.carList) {
            assertThat(car.remainMoveCount).isEqualTo(expected);
        }
    }
}

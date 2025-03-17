import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void 자동차_생성() {
        Car car = Car.create();
        assertThat(car).isInstanceOf(Car.class);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_여러_대_생성() {
        int carCount = 5;
        Cars cars = Cars.create(carCount);
        assertThat(cars.getValues()).hasSize(carCount);
        assertThat(cars.getPositions()).hasSize(carCount);
        assertThat(cars.getPositions()).allMatch(position -> position.equals(1));
    }

}

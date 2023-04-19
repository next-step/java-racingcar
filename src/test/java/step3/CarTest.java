package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step3.model.Car;

public class CarTest {

    private static int ZERO = 0;

    @Test
    void 자동차_이동_테스트() {
        {
            Car car = new Car(ZERO, bound -> 3);
            car.increaseDistance();
            Assertions.assertThat(car.getDistance()).isEqualTo(ZERO);
        }
        {
            Car car = new Car(ZERO, bound -> 5);
            car.increaseDistance();
            Assertions.assertThat(car.getDistance()).isEqualTo(++ZERO);
        }
    }

}

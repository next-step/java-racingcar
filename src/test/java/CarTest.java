import domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


    @Test
    public void 자동차_생성처리() {
        Car car = new Car();
        assertThat(car.getDistance()).isEqualTo(0);

    }

    @Test
    public void 자동차_이동처리() {
        Car car = new Car();
        car.move();
        car.move();
        car.move();
        assertThat(car.getDistance()).isEqualTo(3);
    }

    @Test
    public void 자동차_이동거리출력() {
        Car car = new Car();
        car.move();
        car.move();
        assertThat(car.toString()).isEqualTo("--");
    }
}

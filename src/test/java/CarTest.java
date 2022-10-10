import domain.Car;
import domain.NumberUtils;
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
    public void 자동차_정지_with_조건() {
        Car car = new Car();
        car.moveWithConditon(5,2);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    public void 자동차_이동_with_조건() {
        Car car = new Car();
        car.moveWithConditon(3,2);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}

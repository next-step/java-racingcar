package racing;

import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void move() {
        Car car = new Car();
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void getPosition(){
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }

}

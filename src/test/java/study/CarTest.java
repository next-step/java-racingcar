package study;

import com.step3.model.car.Car;
import com.step3.model.car.CarId;
import com.step3.model.car.CarPosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    @Test
    @DisplayName("Car class 생성자 test")
    void create() {
        Car car = new Car(new CarId(0), new CarPosition(0));
        assertThat(car).isEqualTo(new Car(new CarId(0), new CarPosition(0)));
    }

    @Test
    @DisplayName("Car move 후 Car class로 return test")
    void move() {
        Car car = new Car(new CarId(0), new CarPosition(0));
        Car movedCar = new Car(new CarId(0), new CarPosition(1));

        assertThat(car.move(true).getPosition().getCarPosition())
                .isEqualTo(movedCar.getPosition().getCarPosition());
    }
}

package study;

import com.step3.model.car.*;
import com.step3.model.car.strategy.CarMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    @Test
    @DisplayName("Car class 생성자 test")
    void create() {
        Car car = new Car(new Name("pobi"), new Position(0), new CarMoveStrategy());
        assertThat(car).isEqualTo(new Car(new Name("pobi"), new Position(0), new CarMoveStrategy()));
    }

    @Test
    @DisplayName("Car move 후 Car class로 return test")
    void move() {
        Car car = new Car(new Name("pobi"), new Position(0), new CarMoveStrategy());
        Car movedCar = new Car(new Name("pobi"), new Position(1), new CarMoveStrategy());

        assertThat(car.move(true).getPosition())
                .isEqualTo(movedCar.getPosition());
    }


}

package study;

import com.step3.model.car.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    @Test
    @DisplayName("Car class 생성자 test")
    void create() {
        Car car = new Car(new Name("pobi"), new Position(0));
        assertThat(car).isEqualTo(new Car(new Name("pobi"), new Position(0)));
    }

    @Test
    @DisplayName("Car move 후 Car class로 return test")
    void move() {
        Car car = new Car(new Name("pobi"), new Position(0));

        assertThat(car.move(() -> false).getPosition())
                .isEqualTo(new Position(0));

        assertThat(car.move(() -> true).getPosition())
                .isEqualTo(new Position(1));
    }
}

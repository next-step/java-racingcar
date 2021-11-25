package racing.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 포지션비교() {
        Car car1 = new Car("car");
        car1.move(5);
        Car car2 = new Car("car");
        car2.move(6);
        assertThat(car1).isEqualTo(car2);
        Car car3 = new Car("car");
        car2.move(4);
        assertThat(car1).isNotEqualTo(car3);
    }

    @Test
    void topPosition여부() {
        Car car1 = new Car(new Name("car"), new Position(10));
        Car car2 = new Car(new Name("su2"), new Position(1));
        Car car3 = new Car(new Name("su3"), new Position());
        List<Car> carList = Arrays.asList(car1, car2, car3);

        Car actual = new Car(new Name("car"), new Position(10));

        assertThat(actual.isWinner(carList)).isTrue();
    }
}
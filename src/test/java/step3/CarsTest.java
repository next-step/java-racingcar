package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        cars.addCar(new Car());
        cars.addCar(new Car());
    }

    @Test
    void 자동차_수_확인() {
        assertThat(cars.count()).isEqualTo(2);
    }

    @Test
    void 모든_car에_이동_action_전달() {
        cars.actionAll(car -> car.move(5));
        int actual = cars.unmodifiableList().get(0).location();
        assertThat(actual).isEqualTo(5);
    }

    @Test
    void 모든_car에_멈추는_action_전달() {
        cars.actionAll(Car::stop);
        int actual = cars.unmodifiableList().get(0).location();
        assertThat(actual).isEqualTo(0);
    }
}
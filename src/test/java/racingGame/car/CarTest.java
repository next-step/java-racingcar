package racingGame.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import racingGame.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Mock
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("yohan");
    }

    @Test
    void move() {
        car.forward();
        car.forward();
        car.forward();

        assertThat(car.getPosition()).isEqualTo(3);

        car.forward();
        car.forward();

        assertThat(car.getPosition()).isEqualTo(5);
    }

    @Test
    void name() {
        assertThat(car.getName()).isEqualTo("yohan");
    }
}
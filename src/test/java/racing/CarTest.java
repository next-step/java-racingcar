package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        this.car = Car.of(new CarName("hennry"), new Position());
    }

    @Test
    void of() {
        assertThat(car).isNotNull();
    }

    @Test
    void move() {
        car.move(Car.MOVE_CONDITION);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stop() {
        car.move(Car.MOVE_CONDITION - 1);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void getPosition() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void getName() {
        assertThat(car.getName()).isEqualTo("hennry");
    }

    @Test
    void isWinner() {
        assertThat(car.isWinner(0)).isTrue();
        assertThat(car.isWinner(1)).isFalse();
    }

    @Test
    void getDistance() {
        car.move(Car.MOVE_CONDITION);
        assertThat(car.getPosition()).isEqualTo("-");
    }
}

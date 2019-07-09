package homework.week1.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Car car;
    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 차이름생성자() {
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void movable() {
        assertThat(car.movable(4)).isTrue();
        assertThat(car.movable(3)).isFalse();
    }

    @Test
    void move() {
        assertThat(car.move(true)).isEqualTo(1);
        assertThat(car.move(true)).isEqualTo(2);
        assertThat(car.move(true)).isEqualTo(3);
        assertThat(car.move(false)).isEqualTo(3);
    }
}

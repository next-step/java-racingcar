package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("전진 조건을 만족하지 않으면 자동차는 움직이지 않는다.")
    @Test
    void notMove() {
        int expected = car.position();
        car.move(new FakeMoveStrategy(false));
        assertThat(car.position()).isEqualTo(expected);
    }

    @DisplayName("전진 조건을 만족하면 자동차는 전진한다.")
    @Test
    void move() {
        int expected = car.position() + 1;
        car.move(new FakeMoveStrategy(true));
        assertThat(car.position()).isEqualTo(expected);
    }
}

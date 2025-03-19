package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.exception.CarNameLengthExceedException;

class CarTest {

    @DisplayName("전진 조건을 만족하지 않으면 자동차는 움직이지 않는다.")
    @Test
    void notMove() {
        Car car = new Car("test", new FakeMoveStrategy(false));
        int expected = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("전진 조건을 만족하면 자동차는 전진한다.")
    @Test
    void move() {
        Car car = new Car("test", new FakeMoveStrategy(true));
        int expected = car.getPosition() + 1;
        car.move();
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("자동차의 이름은 5자를 초과할 수 없다.")
    @Test
    void name() {
        String name = "가나다라마바";
        assertThatExceptionOfType(CarNameLengthExceedException.class)
            .isThrownBy(() -> createCar(name));
    }

    private Car createCar(String name) {
        return new Car(name, new FakeMoveStrategy(true));
    }
}

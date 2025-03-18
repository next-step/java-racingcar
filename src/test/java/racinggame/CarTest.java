package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.exception.CarNameLengthExceedException;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("테스트카");
    }

    @DisplayName("전진 조건을 만족하지 않으면 자동차는 움직이지 않는다.")
    @Test
    void notMove() {
        int expected = car.getPosition();
        car.move(new FakeMoveStrategy(false));
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("전진 조건을 만족하면 자동차는 전진한다.")
    @Test
    void move() {
        int expected = car.getPosition() + 1;
        car.move(new FakeMoveStrategy(true));
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("자동차의 이름은 5자를 초과할 수 없다.")
    @Test
    void name() {
        String name = "가나다라마바";
        assertThatExceptionOfType(CarNameLengthExceedException.class)
            .isThrownBy(() -> new Car(name));
    }

}

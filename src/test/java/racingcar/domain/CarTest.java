package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("Car를 생성 시 이름이 5글자가 넘으면 IllegalArgumentException을 발생시킨다.")
    public void createCar() {
        assertThatThrownBy(() -> new Car("longName"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("move method true를 넘겨주면 position 객체의 값이 1 증가한다.")
    public void move() {
        Car car = new Car("aaa");
        car.move(() -> true);

        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("move method에 false를 넘겨주면 아무것도 변하지 않는다.")
    public void stop() {
        Car car = new Car("bbb");
        car.move(() -> false);

        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }
}

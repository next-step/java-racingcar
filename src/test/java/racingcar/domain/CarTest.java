package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("생성 시 이름을 부여할 수 있고 기본 생성 위치는 1이다.")
    @Test
    void createCar() {
        Car car = new Car("noose");

        assertThat(car.name()).isEqualTo("noose");
        assertThat(car.positionValue()).isEqualTo(1);
    }

    @DisplayName("생성 시 위치를 지정할 수 있다.")
    @Test
    void createCarWithPosition() {
        Car car = new Car("test", 2);

        assertThat(car.position()).isEqualTo(new Position(2));
    }

    @DisplayName("자동차의 위치 비교")
    @Test
    void isSamePosition() {
        Car car = new Car("test", 2);

        assertThat(car.isSamePosition(new Position(2))).isTrue();
    }

    @DisplayName("위치가 음수인 경우 예외 발생")
    @Test
    void createCarWithNegativePosition() {
        assertThatThrownBy(() -> new Car("test", -1)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이동 확인")
    @Test
    void move() {
        Car car = new Car("test");

        Car movedCar = car.move(() -> true);

        assertThat(movedCar.position()).isEqualTo(new Position(2));
    }
}

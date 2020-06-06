package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {
    @Test
    @DisplayName("isMovable에 따라 자동차의 위치 테스트")
    void isCarMoveIfIsMovableTrue() {
        Car car = new Car("Hello", 10);

        car.move(true);

        assertThat(car.getLocation()).isEqualTo(11);
    }

    @Test
    @DisplayName("isMovable에 따라 자동차의 위치 테스트")
    void isCarSuspendIfIsMovableFalse() {
        Car car = new Car("Hello", 10);

        car.move(false);

        assertThat(car.getLocation()).isEqualTo(10);
    }


    @Test
    @DisplayName("Clone한 자동차의 인스턴스가 다른 주소 값을 가지고 있는 지 테스트")
    void isCloneCarHasDifferentHash() {
        Car car = new Car("hello");

        Car cloneCar = car.getClone();

        assertThat(car.equals(cloneCar)).isFalse();
    }

    @Test
    @DisplayName("Clone한 자동차가 가지고 있는 값이 원본과 같은 지 테스트")
    void isCloneCarValueEqualWithOriginal() {
        Car car = new Car("Hello", 10);

        Car cloneCar = car.getClone();

        assertAll(
                () -> assertThat(car.getName()).isEqualTo(cloneCar.getName()),
                () -> assertThat(car.getLocation()).isEqualTo(cloneCar.getLocation())
        );
    }
}

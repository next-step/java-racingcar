package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차를 생성한다.")
    void createCarTest() {
        final var car = initCar();
        assertThat(car).isNotNull();
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차가 한칸 전진한다.")
    void moveForwardTest() {
        var car = initCar();
        car.move();
        assertThat(car.getPosition()).isOne();
    }

    @Test
    @DisplayName("자동차가 현재 위치를 반환한다.")
    void getCurrentPositionTest() {
        var moveCount = 3;
        var car = initCar();
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }
        assertThat(car.getPosition()).isEqualTo(moveCount);
    }

    private Car initCar() {
        return Car.create();
    }

}
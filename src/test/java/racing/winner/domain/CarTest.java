package racing.winner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.winner.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("단일 자동차 움직임 테스트")
class CarTest {

    @Test
    @DisplayName("4 입력 시, 전진 값 1 리턴")
    public void workCar() {
        Car car = new Car();
        car.moveOrStop(4);
        int result = car.getDrivingDistance();
        assertEquals(1, result);
    }

    @Test
    @DisplayName("3 입력 시, 정지 값 0 리턴")
    public void stopCar() {
        Car car = new Car();
        car.moveOrStop(3);
        int result = car.getDrivingDistance();
        assertEquals(0, result);
    }

    @Test
    @DisplayName("두번 4 입력 시, 두번 전진 값 2 리턴")
    public void runCar() {
        Car car = new Car();
        car.moveOrStop(4);
        car.moveOrStop(4);
        int result = car.getDrivingDistance();
        assertEquals(2, result);
    }
}
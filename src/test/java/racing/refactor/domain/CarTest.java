package racing.refactor.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("단일 자동차 움직임 테스트")
class CarTest {

    @Test
    @DisplayName("한번 전진 시, 현재 위치가 1이면 성공")
    public void workCar() {
        Car car = new Car("tony");
        car.move(() -> true);
        assertTrue(car.equalsPosition(1));
    }

    @Test
    @DisplayName("정지 시, 현재 위치가 0이면 성공")
    public void runCar() {
        Car car = new Car("tony");
        car.move(() -> false);
        assertTrue(car.equalsPosition(0));
    }

    @Test
    @DisplayName("현재위치 10 입력 후 생성 시, 현재 위치가 10이면 성공")
    public void stopCar() {
        Car car = new Car("tony", 10);
        assertTrue(car.equalsPosition(10));
    }

    @Test
    @DisplayName("비교 테스트")
    public void equals() {
        assertEquals(new Car("test"), new Car("test"));
    }
}
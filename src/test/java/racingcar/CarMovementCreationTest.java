package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarMovementCreationTest {
    private static final int START_POINT = 1;
    private static final String name = "test";
    private final Car car = Car.createCar(name);

    @DisplayName("차량 생성시 초기 상태값 확인")
    @Test
    void carCreationTest() {
        Car testCar = Car.createCar(name);

        int expected = START_POINT;
        int actual = testCar.getPosition();

        assertThat(expected).isEqualTo(actual);
        assertThat(testCar.toString()).isEqualTo(name);
    }

    @DisplayName("연료 주입에 따른 차량 전진 상태 테스팅")
    @Test
    void moveCarTest() {
        int fuel = 4;
        int previousPosition = car.getPosition();

        car.move(fuel);

        int actual = car.getPosition();
        int expected = previousPosition + 1;

        assertThat(expected).isEqualTo(actual);
    }

    @DisplayName("연료 주입에 따른 차량 정지 상태 테스팅")
    @Test
    void stopCarTest() {
        int fuel = 1;
        int expected = car.getPosition();

        car.move(fuel);

        int actual = car.getPosition();

        assertThat(expected).isEqualTo(actual);
    }
}
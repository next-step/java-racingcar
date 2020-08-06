package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class CarMovementCreationTest {
    private static final int START_POINT = 1;
    private static final int FORWARD_THRESHOLD = 4;
    private final Car car = Car.createCar();

    @DisplayName("차량 생성시 초기 위치값 확인")
    @Test
    void carCreationTest() {
        Car testCar = Car.createCar();

        int expected = START_POINT;
        int actual = testCar.getPosition();

        assertThat(expected).isEqualTo(actual);
    }

    @DisplayName("연료 주입에 따른 차량 전진 혹은 정지 상태 테스팅")
    @Test
    void moveCarTest() {
        int fuel = RandomGenerator.generateRandomInt();
        int expected = car.getPosition();

        car.move(fuel);

        int actual = car.getPosition();

        if (fuel >= FORWARD_THRESHOLD) {
            expected++;
        }

        assertThat(expected).isEqualTo(actual);
    }
}
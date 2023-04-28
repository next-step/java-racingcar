package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("Car 클래스의 기능 테스트")
    void CarTest() {
        Car car = new Car("testName");
        // 1회 이동
        int rand = 5;
        car = car.moveFoward(rand);
        // 현재 위치와 이전 위치 차이가 1인지
        assertThat(car.diffBetweenCurrentDistAndPrevDist()).isEqualTo(1);
        // 움직였는지 판별
        assertThat(car.isMoved(1)).isTrue();
    }
}

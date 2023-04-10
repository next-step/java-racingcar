package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 자동차 기능
 * <pre>
 *     - 자동차는 전진 또는 멈출 수 있다.
 *     - 자동차는 엔진과 위치를 갖는다.
 *     - 자동차는 위치정보를 반환한다.
 * </pre>
 */
class CarTest {

    @Test
    @DisplayName("자동차는 주행 수 만큼 위치정보를 가지고 있다.")
    void test1() {
        int driveCount = 5;
        Car car = new Car(new RandomNumberGenerator());
        for (int i = 0; i < driveCount; i++) {
            car.drive();
        }
        assertThat(car.moveCount()).isSameAs(driveCount);
    }
}
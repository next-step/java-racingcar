package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차의 전진 로직 테스트")
    void testForward() {
        Car car = new Car();

        car.forward();
        car.forward();
        car.forward();

        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 위치를 나타내는 문자열 출력 테스트")
    void testGetPositionString() {
        Car car = new Car(4);
        assertThat(car.getPositionString()).isEqualTo("----");
    }
}

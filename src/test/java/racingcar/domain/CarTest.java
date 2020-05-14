package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 클래스 테스트")
public class CarTest {

    @DisplayName("move 메소드를 호출하면 차의 위치를 증가시킨다.")
    @Test
    void move() {
        // given
        Car car = new Car();
        int expectValue = 1;

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(expectValue);
    }
}

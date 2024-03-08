package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 객체 Car 테스트")
public class CarTest {

    @Test
    public void 주행() {
        Car car = new Car();
        boolean result = car.run(new AlwaysMoveCondition());

        assertThat(result).isTrue();
    }

    @Test
    public void 정지() {
        Car car = new Car();
        boolean result = car.run(new NeverMoveCondition());

        assertThat(result).isFalse();
    }
}

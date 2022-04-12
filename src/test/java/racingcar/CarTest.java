package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 클래스 테스트")
public class CarTest {

    @Test
    @DisplayName("자동차가 movable 하다면 한칸 전진한다.")
    void movableTest() {
        Car car = new Car();
        car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return true;
            }
        });
        assertThat(car.state()).isEqualTo(1);
    }
    @Test
    @DisplayName("자동차가 unmovable 하다면 멈춰있는다.")
    void unmovableTest() {
        Car car = new Car();
        car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return false;
            }
        });
        assertThat(car.state()).isEqualTo(0);
    }
}

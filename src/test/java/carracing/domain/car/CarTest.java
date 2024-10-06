package carracing.domain.car;

import carracing.domain.move.MoveStrategy;
import carracing.domain.move.StopStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("차를 움직이지 않으면 위치는 그대로 1이다.")
    @Test
    void moveCar() {
        MoveStrategy moveStrategy = new StopStrategy();
        Car car = Car.from(Name.from("green"));

        Car result = car.move(moveStrategy);

        assertThat(result)
                .isEqualTo(Car.of(Name.from("green"), Position.from(1)));
    }


}

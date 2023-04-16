package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MovementTest {
    @Test
    @DisplayName("randomNumber의 값에 따라(4이상) 차가 이동하는지 확인 한다.")
    void moveCarsTest() {
        // given
        Movement movement = new Movement();
        Car car = new Car(1);
        int initialPosition = 5;
        car.setPosition(initialPosition);

        // when
        movement.moveCars(List.of(car));

        // then
        int positionIfMoved = initialPosition + 1;
        assertThat(car.getPosition()).isBetween(initialPosition, positionIfMoved);
    }
}

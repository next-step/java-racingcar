package RacingCar;

import RacingCar.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("움직임 테스트")
    void move() {
        Cars moveCars = new Cars("tom");
        MovingStrategy moveNumber = new MovingStrategy() {
            @Override
            public boolean moveable() {
                return true;
            }
        };
        moveCars.move(moveNumber);

        assertThat(moveCars.getCars().get(0).isSamePosition(2)).isTrue();
    }

    @Test
    @DisplayName("멈춤 테스트")
    void stop() {
        Cars stopCars = new Cars("tom");
        MovingStrategy stopNumber = new MovingStrategy() {
            @Override
            public boolean moveable() {
                return false;
            }
        };

        stopCars.move(stopNumber);

        assertThat(stopCars.getCars().get(0).isSamePosition(1)).isTrue();
    }


}

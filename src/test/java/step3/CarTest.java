package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setUp(){
        car = new Car(1);
    }

    @Test
    @DisplayName("MoveCondition 이 false 면 이동하지 않는다")
    void noMoving(){
        car.moveIf(() -> false );

        assertThat(car.getMovingDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("MoveCondition 이 true 면 이동한다")
    void moving(){
        car.moveIf(() -> true);
        car.moveIf(() -> true);
        car.moveIf(() -> true);

        assertThat(car.getMovingDistance()).isEqualTo(3);
    }

    @Test
    @DisplayName("MoveCondition 에 따라 이동하거나 이동하지 않거나 한다")
    void moving_and_nomoving(){
        car.moveIf(() -> true);
        car.moveIf(() -> false);
        car.moveIf(() -> true);

        assertThat(car.getMovingDistance()).isEqualTo(2);
    }
}
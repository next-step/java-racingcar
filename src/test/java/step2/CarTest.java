package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("무조건 +1 칸 전진하는 자동차 테스트")
    void move_plus_1() {
        Car car = new Car(1, 0, new MoveStrategy() {
            @Override
            public boolean isMove() {
                return true;
            }
        });
        Car movedCar = car.move();
        assertThat(movedCar.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("무조건 정지하는 자동차 테스트")
    void move_minus_1() {
        Car car = new Car(1, 0, new MoveStrategy() {
            @Override
            public boolean isMove() {
                return false;
            }
        });
        Car movedCar = car.move();
        assertThat(movedCar.getPosition()).isEqualTo(0);
    }

}

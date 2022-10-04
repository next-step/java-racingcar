package racing_car_with_winner.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void move_자동차가_전진한다() {
        Car car = new Car(new CarName("test"));
        Car movedCar = car.tryMove(new MovableStrategy() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        Assertions.assertThat(movedCar.getMoveResult().getMoveCount()).isEqualTo(1);
        Assertions.assertThat(car.getMoveResult()).isEqualTo(movedCar.getMoveResult());
    }

    @Test
    void move_자동차가_멈춘다() {
        Car car = new Car(new CarName("test"));
        Car movedCar = car.tryMove(new MovableStrategy() {
            @Override
            public boolean canMove() {
                return false;
            }
        });

        Assertions.assertThat(movedCar.getMoveResult().getMoveCount()).isEqualTo(0);
    }
}

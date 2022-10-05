package carracing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @DisplayName("멈추면 결과에 기록되지 않는다")
    @ParameterizedTest
    @CsvSource(value = { "false,0" })
    public void tryMove_멈출수있다(boolean movable, int expected) {
        Car car = new Car();

        car.tryMove(new MovableStrategy() {
            @Override
            public boolean canMove() {
                return movable;
            }
        });

        Assertions.assertThat(car.getMoveResult()).isEqualTo(new MoveResult(expected));
    }

    @DisplayName("이동하면 결과에 기록된다")
    @ParameterizedTest
    @CsvSource(value = {"true,1"})
    public void tryMove_이동할수있다(boolean movable, int expected) {
        Car car = new Car();

        car.tryMove(new MovableStrategy<Integer>() {
            @Override
            public boolean canMove() {
                return movable;
            }
        });

        Assertions.assertThat(car.getMoveResult()).isEqualTo(new MoveResult(expected));
    }

}

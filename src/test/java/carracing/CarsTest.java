package carracing;

import carracing.move_strategy.MoveStrategy;
import carracing.move_strategy.RandomMoveStopStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("Cars에서 받은 List<Car>는 변경할 수 없다.")
    void unmodifiableList() {
        // given
        MoveStrategy moveStrategy = new RandomMoveStopStrategy();
        Cars cars = Cars.makeCars(List.of("CAR1", "CAR2"), moveStrategy);

        // when, then
        assertThatThrownBy(cars.getCars()::clear).isInstanceOf(UnsupportedOperationException.class);
    }

}

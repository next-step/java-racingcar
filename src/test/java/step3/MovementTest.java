package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MovementTest {
    private List<Car> cars;
    private Movement movement;

    @BeforeEach
    void setUp() {
        Car car1 = new Car();
        cars = Arrays.asList(car1);
        movement = new Movement(cars);
    }

    @Test
    @DisplayName("random 값이 4보다 크거나 같다면 trace 증가")
    void moveCarsTest_NumberIsEqualOrGreaterThanFour() {
        // given
        int initialTrace = cars.get(0).getTrace();
        int traceIfMoved = initialTrace + 1;
        MovableMoveStrategy movableMoveStrategy = new MovableMoveStrategy();

        // when
        movement.moveCars(movableMoveStrategy);

        // then
        assertThat(cars.get(0).getTrace()).isEqualTo(traceIfMoved);
    }

    @Test
    @DisplayName("random 값이 4보다 작으면 trace 그대로")
    void moveCarsTest_NumberIsLessThanFour() {
        // given
        int initialTrace = cars.get(0).getTrace();
        NonMovableMoveStrategy nonMovableMoveStrategy = new NonMovableMoveStrategy();

        // when
        movement.moveCars(nonMovableMoveStrategy);

        // then
        assertThat(cars.get(0).getTrace()).isEqualTo(initialTrace);
    }
}

package car;

import car.dto.Car;
import car.service.MoveStrategy;
import car.service.Movement;
import car.service.RandomMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MovementTest {
    private List<Car> cars;
    private Movement movement;
    @BeforeEach
    void setUp() {
        Car car1 = new Car("pobi");
        cars = Arrays.asList(car1);

        MoveStrategy moveStrategy = new RandomMoveStrategy();
        movement = new Movement(cars, moveStrategy);
    }
    @Test
    @DisplayName("moveCars에 조건에 해당하는 경우 차가 이동하는지 확인 한다.")
    void moveCarsTest() {
        int initialPosition = cars.get(0).getPosition();
        int positionIfMoved = initialPosition + 1;

        // when
        movement.moveCars();

        // then
        assertThat(cars.get(0).getPosition()).isBetween(initialPosition, positionIfMoved);

    }
}

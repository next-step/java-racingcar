package cc.oakk.racing.domain;

import cc.oakk.racing.domain.predicate.CarForwardCondition;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {
    @Test
    void createCars() {
        CarForwardCondition<Car> condition = createDummyCarForwardCondition();
        CarFactory factory = new CarFactory(condition);
        List<Car> cars = factory.createCars(Arrays.asList("A", "B", "C", "D", "E"));
        assertThat(cars).containsExactly(new Car("A", condition),
                new Car("B", condition), new Car("C", condition),
                new Car("D", condition), new Car("E", condition));
    }

    private CarForwardCondition<Car> createDummyCarForwardCondition() {
        return new CarForwardCondition<>(c -> true, c -> c);
    }
}

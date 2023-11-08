package carracing;

import carracing.domain.car.Car;
import carracing.domain.car.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static carracing.domain.car.Cars.makeCars;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("Cars에서 받은 List<Car>는 변경할 수 없다.")
    void unmodifiableList() {
        // given
        Cars cars = makeCars(List.of("CAR1", "CAR2"));

        // when, then
        assertThatThrownBy(cars.getCars()::clear).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("가장빠른차들/포지션이 가장 높은 차들/목록이 반환된다.")
    void getFastestCar() {
        // given
        Car car1 = new Car("pobi", 3);
        Car car2 = new Car("edu", 4);
        Car car3 = new Car("crong", 4);
        Cars cars = new Cars(List.of(car1, car2, car3));

        // when
        List<Car> winners = cars.getFastestCars();

        // then
        assertThat(winners).containsExactly(car2, car3);
    }
}

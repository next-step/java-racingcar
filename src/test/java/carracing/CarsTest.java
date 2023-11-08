package carracing;

import carracing.domain.car.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static carracing.domain.car.Cars.makeCars;
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

}

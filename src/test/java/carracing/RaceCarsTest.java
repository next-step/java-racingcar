package carracing;

import carracing.domain.car.Car;
import carracing.domain.car.RaceCars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static carracing.domain.car.RaceCars.makeCars;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceCarsTest {
    @Test
    @DisplayName("Cars에서 받은 List<Car>는 변경할 수 없다.")
    void unmodifiableList() {
        // given
        RaceCars raceCars = makeCars(List.of("CAR1", "CAR2"));

        // when, then
        assertThatThrownBy(raceCars.getCars()::clear).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("가장빠른차들/포지션이 가장 높은 차들/목록이 반환된다.")
    void getFastestCar() {
        // given
        Car car1 = new Car("pobi", 3);
        Car car2 = new Car("edu", 4);
        Car car3 = new Car("crong", 4);
        RaceCars raceCars = new RaceCars(List.of(car1, car2, car3));

        // when
        List<Car> winners = raceCars.getFastestCars();

        // then
        assertThat(winners).containsExactly(car2, car3);
    }
}

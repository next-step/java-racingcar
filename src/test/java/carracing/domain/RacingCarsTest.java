package carracing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingCarsTest {

    @Test
    void validate_empty_cars() {
        List<RacingCar> emptyCars = new ArrayList<>();
        assertThatThrownBy(() -> new RacingCars(emptyCars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_success() {
        List<RacingCar> cars = List.of(new RacingCar("kim"), new RacingCar("lee"));
        assertThatCode(() -> new RacingCars(cars)).doesNotThrowAnyException();
    }

    @Test
    void moveAll_success() {
        RacingCar car = new RacingCar("kim");
        RacingCars racingCars = new RacingCars(List.of(car));

        racingCars.moveAll(() -> 4);

        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }
}
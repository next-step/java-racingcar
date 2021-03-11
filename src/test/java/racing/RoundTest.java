package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {
    @Test
    @DisplayName("인자로 받은 List<Car> 객체를 deep copy 한다.")
    void createFrom() {
        final List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        final Round round = Round.createFrom(cars);
        final List<Car> roundCars = round.getCars();

        assertThat(roundCars).isNotEqualTo(cars);
        for (int i = 0; i < cars.size(); i++) {
            assertThat(roundCars.get(i)).isNotEqualTo(cars.get(i));
            assertThat(roundCars.get(i).getDistance()).isEqualTo(cars.get(i).getDistance());
        }
    }
}

package racing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @Test
    void 게임_진행() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1));
        Racing.goRacing(cars, 5);
        int distance = cars.get(0).carDistance();
        assertThat(distance).isLessThanOrEqualTo(5);
    }
}
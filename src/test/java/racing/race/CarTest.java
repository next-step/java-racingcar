package racing.race;

import org.junit.jupiter.api.Test;
import racing.race.Car;
import racing.Constants;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void forward_car() {
        Car car = new Car();
        List<Boolean> forwardResults = List.of(true, false, false, true, false);

        forwardResults.forEach(car::forward);

        for (int i = 0; i < forwardResults.size(); i ++) {
            assertThat(car.raceResult(i))
                    .isEqualTo(forwardResults.get(i) ? Constants.FORWARD : Constants.STOP);
        }
    }
}

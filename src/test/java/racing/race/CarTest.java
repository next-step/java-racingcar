package racing.race;

import org.junit.jupiter.api.Test;
import racing.race.Car;
import racing.Constants;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void forward_car() {
        Car car = new Car();
        List<Boolean> forwardResults = List.of(true, false, false, true, false);

        forwardResults.forEach(car::forward);

        for (Boolean forwardResult : forwardResults) {
            assertThat(car.raceResult())
                    .isEqualTo(forwardResult ? Constants.FORWARD : Constants.STOP);
        }

        assertThatThrownBy(car::raceResult).isInstanceOf(IndexOutOfBoundsException.class);
    }
}

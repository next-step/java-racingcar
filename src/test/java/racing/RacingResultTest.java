package racing;

import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.TrackResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultTest {
    @Test
    void create() {
        Car car = Car.of("car");
        List<Car> cars = Arrays.asList(car, car);
        assertThat(new TrackResult(cars).getCars().size()).isEqualTo(2);
    }
}
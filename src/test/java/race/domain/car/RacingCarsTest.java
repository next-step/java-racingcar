package race.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @Test
    @DisplayName("생성 테스트")
    void create() {
        final Car car1 = new Car(new Name("1"));
        final Car car2 = new Car(new Name("2"));
        final Car car3 = new Car(new Name("3"));

        assertThat(new RacingCars(Arrays.asList(car1, car2, car3)))
                .isEqualTo(new RacingCars(Arrays.asList(car1, car2, car3)));
    }
}

package racingcar.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    private static final int TEST_ID = 1;
    private static final String TEST_NAME = "jason";

    @Test
    public void 생성() {
        // given
        final List<RacingCar> cars = Arrays.asList(new RacingCar(TEST_ID, TEST_NAME));

        // when
        final RacingCars racingCars = new RacingCars(cars);

        // then
        assertThat(racingCars).isNotNull();
        assertThat(racingCars.get()).hasSize(cars.size());
    }
}
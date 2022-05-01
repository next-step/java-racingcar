package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {


    @DisplayName("우승자를 찾는다.")
    @Test
    void findWinners() {
        final List<String> namesOfCars = getDefaultNamesOfCars();
        final RacingCars racingCars = new RacingCars(namesOfCars);

        racingCars.run(getDefaultRule());

        assertThat(racingCars.findWinners()).hasSize(namesOfCars.size());
    }

    GameRule getDefaultRule() {
        return () -> true;
    }

    List<String> getDefaultNamesOfCars() {
        return Arrays.asList("solar", "holar", "cola");

    }
}

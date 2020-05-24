package racingCar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {
    private final String[] names = {"pobi", "crong", "lion"};

    @Test
    @DisplayName("자동차 Name 설정")
    void initRacingCars() {
        RacingCars racingCars = new RacingCars(names);

        List<String> racingCarNames = racingCars.getRacingCarList().stream()
                                                .map(RacingCar::getName)
                                                .collect(Collectors.toList());

        assertThat(racingCarNames).hasSize(names.length)
                .hasSameElementsAs(Arrays.asList(names));
    }

    @Test
    void move() {
        RacingCars racingCars = new RacingCars(names);

        List<RacingCar> racingCarList = racingCars.move(() -> true);
        int racingCarsCount = (int) racingCarList.stream()
                .filter(racingCar -> racingCar.getPosition() == 1).count();

        assertThat(racingCarsCount).isEqualTo(3);
    }
}

package racingcargame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarFactoryTest {

    @ParameterizedTest
    @CsvSource(value = {"-1,0", "0,0", "1,1"})
    void makeCarsTest(int carCount, int makedCarCount) {
        List<RacingCar> racingCars = RacingCarFactory.makeCars(carCount);

        assertThat(racingCars.size()).isEqualTo(makedCarCount);
    }

}
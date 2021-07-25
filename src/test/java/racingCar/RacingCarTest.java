package racingCar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @ParameterizedTest
    @CsvSource({"2,4"})
    public void readyCar(int carCount, int moveCount) {
        RacingCar racingCar = new RacingCar(carCount,moveCount);
        List<Car> cars = racingCar.readyCar();

        assertThat(cars.size()).isEqualTo(carCount);
    }
}
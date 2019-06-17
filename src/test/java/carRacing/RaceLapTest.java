package carRacing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceLapTest {


    @ParameterizedTest
    @CsvSource(value = {
            "4, 1",
            "5, 1",
            "6, 1",
            "9, 1",
    })
    void moveAllCars(int inputPowerOutput, int expected) {
        RaceLap raceLap = new RaceLap(new MockEngine(inputPowerOutput), 5).race();
        List<Car> cars = raceLap.getCars();
        for (Car car : cars) {
            assertThat(car.getMovement()).isEqualTo(expected);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3, 0",
            "2, 0",
            "1, 0",
            "0, 0",
    })
    void stopAllCars(int inputPowerOutput, int expected) {
        RaceLap raceLap = new RaceLap(new MockEngine(inputPowerOutput), 5).race();
        List<Car> cars = raceLap.getCars();
        for (Car car : cars) {
            assertThat(car.getMovement()).isEqualTo(expected);
        }
    }
}
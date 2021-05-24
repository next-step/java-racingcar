package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DriveTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();

        cars.add(new Car("java", 1));
        cars.add(new Car("php", 2));
        cars.add(new Car("python", 3));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,3,1", "0,4,2", "1,3,2", "1,4,3", "2,3,3", "2,4,4"})
    void moveOrStopCar(String value1, String value2, String value3) {
        int index = Integer.valueOf(value1);
        int randomNumber = Integer.valueOf(value2);
        int km = Integer.valueOf(value3);

        Drive drive = new Drive(cars);
        drive.moveOrStopCar(randomNumber, cars.get(index));

        Copy copy = new Copy(cars);
        List<Car> copiedCars = copy.createCopiedCars();

        assertThat(copiedCars.get(index).getKm()).isEqualTo(km);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3", "4,4", "5,5"})
    void carRacing(String value1, String value2) {
        int count = Integer.valueOf(value1);
        int expected = Integer.valueOf(value2);

        Drive drive = new Drive(cars);

        List<RaceResult> raceResults = drive.carRacing(count);

        assertThat(raceResults.size()).isEqualTo(expected);
    }
}

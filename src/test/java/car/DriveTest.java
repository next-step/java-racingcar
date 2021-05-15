package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DriveTest {
    private Drive drive;

    @BeforeEach
    void setUp() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("java", 1));
        cars.add(new Car("php", 2));
        cars.add(new Car("python", 3));

        drive = new Drive(cars);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,2", "2,3"})
    void carDrive(String value1, String value2) {
        List<Car> copiedCars = drive.carDrive();

        int index = Integer.valueOf(value1);
        int km = Integer.valueOf(value2);

        assertThat(copiedCars.get(index).getKm()).isEqualTo(km);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3", "4,4", "5,5"})
    void carRacing(String value1, String value2) {
        int count = Integer.valueOf(value1);
        int expected = Integer.valueOf(value2);

        List<RaceResult> raceResults = drive.carRacing(count);

        assertThat(raceResults.size()).isEqualTo(expected);
    }
}

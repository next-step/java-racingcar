package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import race.domain.MovePolicy;
import race.domain.RacingCars;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    RacingCars cars;
    MovePolicy movePolicy;

    @BeforeEach
    void setup() {
        movePolicy = () -> 1;
    }

    @DisplayName("n개의 자동차가 생성되는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void createTest(int numOfCar) {
        RacingCars cars = RacingCars.createCars(numOfCar, movePolicy);

        assertThat(cars.size()).isEqualTo(numOfCar);
    }

    @DisplayName("n개의 자동차가 m번 움직이는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,3", "3,1", "2,2"})
    void moveTest(int numOfCar, int numOfTry) {
        RacingCars cars = RacingCars.createCars(numOfCar, movePolicy);

        for (int i = 0; i < numOfTry; i++) {
            cars.step();
        }

        cars.getDistanceOfCars()
                .forEach(distance -> assertThat(distance).isEqualTo(numOfTry));
    }
}

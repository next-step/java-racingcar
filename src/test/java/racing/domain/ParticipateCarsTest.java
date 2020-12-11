package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import racing.domain.Car;
import racing.domain.ParticipateCars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParticipateCarsTest {

    private ParticipateCars participateCars;

    @BeforeEach
    void setup() {
        participateCars = new ParticipateCars();
    }

    @Test
    void createCar() {
        String[] carsName = {"Morris", "Daniel", "Choi"};
        participateCars.createCar(carsName);
        List<Car> cars = participateCars.getCars();
        assertAll(
                () -> assertThat(cars.get(0).getName()).isEqualTo("Morris"),
                () -> assertThat(cars.get(1).getName()).isEqualTo("Daniel"),
                () -> assertThat(cars.get(2).getName()).isEqualTo("Choi")
        );
    }

    @Test
    void createCarNumberTest() {
        String[] carsName = {"Morris", "Daniel", "Choi"};
        participateCars.createCar(carsName);
        assertThat(participateCars.getCars().size()).isEqualTo(3);
    }

    @Test
    void findMaxTotalMeterTest() {
        List<Car> testCarList = Arrays.asList( new Car("Car1",4), new Car("Car2",4), new Car("Car3",2) );
        int maxTotalMeter = participateCars.findMaxTotalMeter(testCarList);
        assertThat(maxTotalMeter).isEqualTo(4);
    }

    @Test
    void findWinnerName() {
        List<Car> testCarList = Arrays.asList( new Car("Car1",4), new Car("Car2",4), new Car("Car3",2) );
        int maxMeter = 4;
        List<String> winnerNames = participateCars.findWinnerName(maxMeter, testCarList);
        assertThat(winnerNames.size()).isEqualTo(2);
    }
}
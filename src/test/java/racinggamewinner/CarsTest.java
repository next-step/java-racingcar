package racinggamewinner;

import org.junit.jupiter.api.Test;
import racinggamewinner.domain.Car;
import racinggamewinner.domain.Cars;
import racinggamewinner.random.NumberGenerateStrategy;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    static final int TEST_CAR_COUNT = 3;
    static final int DEFAULT_POSITION = 0;
    static final int TEST_MOVING_NUMBER = 1;
    NumberGenerateStrategy numberGenerateStrategy;
    Cars cars;

    @Test
    void 쉼표기준으로_자동차_생성() {
        String carNames = "red,kaki,blue";
        cars = Cars.registerCars(carNames);
        assertThat(cars.carCount()).isEqualTo(TEST_CAR_COUNT);
    }


    @Test
    void registerCars테스트() {
        String carName = "red";
        List<Car> carList = List.of(new Car("red"));
        Cars cars = Cars.registerCars(carName);
        Cars decideCars = new Cars(carList);

        assertThat(cars.carNameAndPositions())
                .isEqualTo(decideCars.carNameAndPositions());
    }


    @Test
    void carNameAndPosition테스트() {
        cars = Cars.registerCars("red,blue");
        assertThat(cars.carNameAndPositions())
                .isEqualTo(Map.of("red", DEFAULT_POSITION, "blue", DEFAULT_POSITION));
    }


    @Test
    void maxCarPosition() {
        String carNames = "red,kaki";
        numberGenerateStrategy = new NumberGenerateStrategy(new AlwaysMoveNumber());
        cars = Cars.registerCars(carNames);
        cars.recordEachRoundMoving(numberGenerateStrategy);
        assertThat(cars.maxCarPosition()).isEqualTo(TEST_MOVING_NUMBER);
    }
}

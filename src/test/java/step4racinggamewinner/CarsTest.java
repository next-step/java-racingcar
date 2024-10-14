package step4racinggamewinner;

import org.junit.jupiter.api.Test;
import step4racinggamewinner.random.RandomGenerator;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    static final int TEST_CAR_COUNT = 3;
    static final int DEFAULT_POSITION = 0;
    static final int TEST_MOVING_NUMBER = 1;
    RandomGenerator randomGenerator;
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
        randomGenerator = new AlwaysMoveNumber();
        cars = Cars.registerCars(carNames);
        cars.recordEachRoundMoving(randomGenerator);
        assertThat(cars.maxCarPosition()).isEqualTo(TEST_MOVING_NUMBER);
    }
}

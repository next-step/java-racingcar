package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class CarFactoryTest {
    @ParameterizedTest
    @MethodSource("getManufactoringCarsTestParams")
    public void manufactoringCars(String carNameList, int numOfCars, int tryingCount) {
        List<Car> cars = CarFactory.manufactoringCars(carNameList, tryingCount);
        assertThat(cars.size()).isEqualTo(numOfCars);
        cars.forEach(car -> {
            assertThat(car).isNotNull();
            assertThat(car.getHistoryCount()).isEqualTo(tryingCount);

        });
    }

    private static Stream<Arguments> getManufactoringCarsTestParams() {
        return Stream.of(
                Arguments.of("niro,tusan,genesis,porsche,morning", 5, 3),
                Arguments.of("niro,tusan,genesis", 3, 5),
                Arguments.of("niro,tusan,genesis,porsche", 4, 4),
                Arguments.of("niro,tusan,genesis,porsche,morning,niro,tusan,genesis,porsche,morning", 10, 5),
                Arguments.of("niro,tusan,genesis,porsche,morning", 5, 10)
        );
    }
}

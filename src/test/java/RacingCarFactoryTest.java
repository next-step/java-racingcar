import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.RacingCar;
import racingcar.RacingCarFactory;

public class RacingCarFactoryTest {

    @ParameterizedTest
    @MethodSource("getManufactoringCarsTestParams")
    public void manufactoringCars(int numOfCars, int tryingCount) {
        List<RacingCar> cars = RacingCarFactory.manufactoringCars(numOfCars, tryingCount);
        assertThat(cars.size()).isEqualTo(numOfCars);
        cars.forEach(car -> {
            assertThat(car).isNotNull();
            assertThat(car.getHistoryCount()).isEqualTo(tryingCount);

        });
    }

    private static Stream<Arguments> getManufactoringCarsTestParams() {
        return Stream.of(
                Arguments.of(5, 3),
                Arguments.of(3, 5),
                Arguments.of(4, 4),
                Arguments.of(10, 5),
                Arguments.of(5, 10)
        );
    }
}

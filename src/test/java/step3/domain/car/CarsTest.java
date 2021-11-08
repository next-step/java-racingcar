package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static final int LOCATION = 0;
    private static final int INTERVAL = 1;
    private static final int CAR_COUNT = 3;
    private static final int ROUND_COUNT = 3;

    @DisplayName("전진, 정지 잘하는지 테스트")
    @ParameterizedTest
    @MethodSource(value = "generateGoInputs")
    void goTest(int inputPower, int moveDistance) {
        //given
        List<Car> inputCars = createCars(LOCATION);
        Cars cars = new Cars(inputCars);

        //when
        for (int i = 0; i < ROUND_COUNT; i++) {
            cars.go(() -> inputPower);
        }

        //when
        List<Car> expectedCars = createCars(LOCATION + moveDistance);
        assertThat(inputCars).isEqualTo(expectedCars);
    }

    private static Stream<Arguments> generateGoInputs() {
        return Stream.of(
                Arguments.of(3, 0),
                Arguments.of(4, INTERVAL * ROUND_COUNT)
        );
    }

    private List<Car> createCars(int location) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < CAR_COUNT; i++) {
            cars.add(new Car(Location.placeOn(location, INTERVAL)));
        }
        return cars;
    }

}

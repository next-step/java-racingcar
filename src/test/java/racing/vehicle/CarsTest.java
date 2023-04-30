package racing.vehicle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    static Stream<Arguments> carNames() {
        return Stream.of(
                Arguments.arguments(new CarNames("car1,car2,car3"))
        );
    }

    @ParameterizedTest(name = "Creating cars with carNames - {0}")
    @MethodSource("carNames")
    public void createCarsWithValidCarNames(CarNames carNames) {
        Cars cars = new Cars(carNames);
        assertThat(cars.getCars()).hasSize(carNames.getSize());
    }

    @ParameterizedTest(name = "Creating cars with null carNames - {0}")
    @NullSource
    public void createCarsWithNullCarNames(CarNames carNames) {
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(RuntimeException.class);
    }
}

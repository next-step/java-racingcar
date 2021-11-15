package race;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import race.domain.Car;
import race.domain.CarName;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SetUpCarsTest {
    @ParameterizedTest
    @NullAndEmptySource
    void whenCarNamesIsNullOrEmpty(List<CarName> carNames) {
        assertThatThrownBy(() -> new SetUpCars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("carNames")
    void setUp(Collection<CarName> carNames) {
        SetUpCars setUpCars = new SetUpCars(carNames);

        assertThat(setUpCars.setUp().stream().map(Car::name).collect(Collectors.toList()))
                .containsExactlyElementsOf(carNames);
    }

    private static Stream<Arguments> carNames() {
        return Stream.of(
                Arguments.of(dummyCarNames(1)),
                Arguments.of(dummyCarNames(1)),
                Arguments.of(dummyCarNames(1))
        );
    }

    private static Collection<CarName> dummyCarNames(int numberOfCars) {
        ArrayList<CarName> carNames = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            carNames.add(dummyCarName());
        }
        return Collections.unmodifiableCollection(carNames);
    }

    private static CarName dummyCarName() {
        return new CarName(UUID.randomUUID().toString().substring(0, 4));
    }
}
package racing.vehicle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import racing.testutil.DeterministicHighRandom;
import racing.testutil.DeterministicLowRandom;

import java.util.List;
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
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getWinners() {
        // given
        Car winner = new Car(new CarName("car1"), new RandomEngine(new DeterministicHighRandom()));
        Car loser1 = new Car(new CarName("car2"), new RandomEngine(new DeterministicLowRandom()));
        Car loser2 = new Car(new CarName("car3"), new RandomEngine(new DeterministicLowRandom()));
        List<Car> participants = List.of(winner, loser1, loser2);
        Cars cars = new Cars(participants);

        // when
        cars.move();

        // then
        assertThat(cars.getWinners().getCars()).isEqualTo(List.of(winner));
    }
}

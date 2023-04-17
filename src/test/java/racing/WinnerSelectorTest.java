package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerSelectorTest {

    @ParameterizedTest
    @MethodSource("getCars")
    void selectWinnerTest(List<Car> cars, List<Car> expected) {

        List<Car> winners = WinnerSelector.selectWinner(cars);
        assertThat(winners).containsAll(expected);
    }

    private static Stream<Arguments> getCars() {

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.forward(() -> true);

        Car car4 = new Car("car4");
        Car car5 = new Car("car5");
        Car car6 = new Car("car6");

        car4.forward(() -> true);
        car5.forward(() -> true);
        car6.forward(() -> true);
        return Stream.of(
                Arguments.of(List.of(car1, car2, car3), List.of(car1)),
                Arguments.of(List.of(car4, car5, car6), List.of(car4, car5, car6))
        );
    }

}
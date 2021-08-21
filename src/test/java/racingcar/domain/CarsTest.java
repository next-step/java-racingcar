package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest
    @MethodSource("provideCarNamesForCars")
    void Cars(String[] carNames, int carNum) {
        Cars cars = new Cars(carNames);

        for (int i = 0; i < carNames.length; i++) {
            assertThat(cars.getCarsList().get(i).getNameInString()).isEqualTo(carNames[i].trim());
        }
    }

    private static Stream<Arguments> provideCarNamesForCars() {
        return Stream.of(
                Arguments.of(new String[]{"ABC"}, 1),
                Arguments.of(new String[]{"ABC", "DEF"}, 2),
                Arguments.of(new String[]{"ABC", "DEF", "HIJ", "KLM"}, 4)
        );
    }

    @Test
    void sortByLocation() {
        Cars cars = new Cars(new Car[]{
                new Car("A", 7),
                new Car("B", 1),
                new Car("C", 4),
                new Car("D", 5),
                new Car("E", 3),
                new Car("F", 8)
        });
        Cars expectedCars = new Cars(new Car[]{
                new Car("F", 8),
                new Car("A", 7),
                new Car("D", 5),
                new Car("C", 4),
                new Car("E", 3),
                new Car("B", 1)
        });

        cars.sortByLocation();

        assertThat(cars.equalsExactly(expectedCars)).isEqualTo(true);
    }

    @Test
    void equals() {
        Cars cars = new Cars(new Car[]{
                new Car("A", 7),
                new Car("B", 1),
                new Car("C", 4),
                new Car("D", 5),
                new Car("E", 3),
                new Car("F", 8)
        });
        Cars expectedCars = new Cars(new Car[]{
                new Car("A", 7),
                new Car("B", 1),
                new Car("C", 4),
                new Car("D", 5),
                new Car("E", 3),
                new Car("F", 8)
        });
        assertThat(cars.equals(expectedCars)).isEqualTo(true);
        assertThat(cars.equalsExactly(expectedCars)).isEqualTo(true);

        cars = new Cars(new Car[]{
                new Car("C", 4),
                new Car("A", 7),
                new Car("F", 8),
                new Car("B", 1),
                new Car("E", 3),
                new Car("D", 5)
        });
        assertThat(cars.equals(expectedCars)).isEqualTo(true);
        assertThat(cars.equalsExactly(expectedCars)).isEqualTo(false);
    }

    @Test
    void calculateWinners() {
        Cars cars = new Cars(new Car[]{
                new Car("A", 7),
                new Car("B", 1),
                new Car("C", 4),
                new Car("D", 10),
                new Car("E", 3),
                new Car("F", 8),
                new Car("G", 10)
        });

        List<Car> expected = new ArrayList<>();
        expected.add(new Car("D", 10));
        expected.add(new Car("G", 10));
        assertThat(cars.calculateWinners().equals(new Winners(expected))).isEqualTo(true);
    }
}

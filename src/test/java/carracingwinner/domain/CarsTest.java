package carracingwinner.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,kim,lee:3", "pobi:1"}, delimiter = ':')
    void createTest(String names, int count) {
        Cars cars = new Cars(names.split(","));

        assertThat(cars.getCars().size()).isEqualTo(count);
    }

    @ParameterizedTest
    @MethodSource(value = "provideCars")
    void getLastWinnersTest(List<Car> carList, String winner) {
        Cars cars = new Cars(carList);
        
        assertThat(cars.getLastWinners()).containsExactly(winner);
    }

    private static Stream<Arguments> provideCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi", 0));
        carList.add(new Car("pobi1", 1));
        carList.add(new Car("pobi2", 2));

        return Stream.of(
                Arguments.of(carList, "pobi2")
        );
    }

}
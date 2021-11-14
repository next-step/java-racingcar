package carracingwinner.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @ParameterizedTest
    @MethodSource(value = "provideCars")
    void createTest(List<Car> cars, String resultValue, String winner) {
        Result result = new Result(cars);

        assertThat(result.getResult()).isEqualTo(resultValue);
    }

    private static Stream<Arguments> provideCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 0));
        cars.add(new Car("pobi1", 1));
        cars.add(new Car("pobi2", 2));

        return Stream.of(
                Arguments.of(cars, "pobi : \npobi1 : -\npobi2 : --\n", "pobi2")
        );
    }

}

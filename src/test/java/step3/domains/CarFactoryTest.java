package step3.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarFactoryTest {
    @ParameterizedTest
    @MethodSource("parametersProvider")
    void a(String input, List<Car> expected) {
        CarFactory factory = new CarFactory(input);

        List<Car> carList = factory.createCarList();

        IntStream.range(0, carList.size()).boxed()
                .forEach(i -> assertThat(carList.get(i)).isEqualTo(expected.get(i)));
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments("a", List.of(Car.init("a"))),
                arguments("aaaa,bbbbb", List.of(Car.init("aaaa"), Car.init("bbbbb")))
        );
    }
}

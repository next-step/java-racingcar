package racing.vehicle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNamesTest {
    static Stream<Arguments> carNames() {
        return Stream.of(
                Arguments.arguments("car1,car2,car3", List.of(new CarName("car1"), new CarName("car2"), new CarName("car3"))),
                Arguments.arguments("car1", List.of(new CarName("car1")))
        );
    }

    @ParameterizedTest(name = "Creating carNames with \"{0}\"")
    @MethodSource("carNames")
    public void createCarNamesWithValidCarNames(String carNamesMessage, List<CarName> result) {
        CarNames carNames = new CarNames(carNamesMessage);
        assertThat(carNames.getNames()).isEqualTo(result);
    }

    @ParameterizedTest(name = "Creating carNames with null or empty - {0}")
    @NullAndEmptySource
    public void createCarNamesWithNullCarNames(String carNamesMessage) {
        assertThatThrownBy(() -> new CarNames(carNamesMessage))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

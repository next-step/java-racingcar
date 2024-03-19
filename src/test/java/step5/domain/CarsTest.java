package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.Cars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CarsTest {

    @DisplayName("자동차 일급 컬렉션 생성자")
    @ParameterizedTest
    @MethodSource("carNamesWithIsEmptyExpectResult")
    public void constructor(List<String> carNames, boolean expectIsEmpty) {
        final Cars cars = Cars.from(carNames);

        assertThat(cars.isEmpty()).isEqualTo(expectIsEmpty);
    }

    private static Stream<Arguments> carNamesWithIsEmptyExpectResult() {
        return Stream.of(
                arguments(List.of("pobi", "crong", "honux"), false),
                arguments(Collections.emptyList(), true)
        );
    }
}

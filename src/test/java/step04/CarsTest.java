package step04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private static Stream<Arguments> provideCarMoveResult() {
        return Stream.of(
                Arguments.of(true, 0, new Integer[]{1, 1, 1}),
                Arguments.of(false, 0, new Integer[]{0, 0, 0}),
                Arguments.of(false, 2, new Integer[]{2, 2, 2}),
                Arguments.of(true, 2, new Integer[]{3, 3, 3})
        );
    }

    @DisplayName("자동차들의 움직임 테스트")
    @ParameterizedTest
    @MethodSource("provideCarMoveResult")
    public void test_move(boolean isMovable, int position, Integer[] expected) {
        Cars cars = Cars.of(new String[]{"1", "2", "3"}, position, () -> isMovable);
        cars.move();
        Integer[] result = cars.cars
                .stream()
                .map(car -> car.getPosition())
                .toArray(Integer[]::new);

        assertThat(result).isEqualTo(expected);
    }

}

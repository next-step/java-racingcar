package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @ParameterizedTest
    @DisplayName("Car 이동하기")
    @ValueSource(ints = {0, 1, 2})
    void move(int movementExpected) {
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        Cars cars = new Cars(names);
        List<Integer> positions = cars.getCarPositions();

        cars.move(() -> movementExpected);
        List<Integer> positionsAfterMove = cars.getCarPositions();

        IntStream.range(0, names.size())
                .forEach(idx -> {
                    int movement = positionsAfterMove.get(idx) - positions.get(idx);
                    assertThat(movement).isEqualTo(movementExpected);
                });
    }
}

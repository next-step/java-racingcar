package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @ParameterizedTest
    @DisplayName("Car 이동하기")
    @ValueSource(ints = {0, 1, 2})
    void move(int movementExpected) {
        int carNum = 2;
        Cars cars = new Cars(carNum, () -> movementExpected);
        List<Integer> positions = cars.getCarPositions();

        cars.move();
        List<Integer> positionsAfterMove = cars.getCarPositions();

        IntStream.range(0, carNum)
                .forEach(idx -> {
                    int movement = positionsAfterMove.get(idx) - positions.get(idx);
                    assertThat(movement).isEqualTo(movementExpected);
                });
    }
}

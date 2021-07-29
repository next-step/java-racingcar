package carracing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest(name = "입력 값에 따라 자동차 목록 내 모든 자동차가 한번씩 움직인다.")
    @ValueSource(ints = {0, 3, 4, 9})
    public void carsMoveTest(int mockRandomNumber) {
        int[] carPositions = new int[] {1, 3, 5};
        Cars cars = createCars(carPositions);
        cars.move(() -> RandomNumber.of(mockRandomNumber));
        assertThat(cars.getPositions())
                .isEqualTo(expectedPositions(carPositions, mockRandomNumber > 3));
    }

    private Cars createCars(int[] carPositions) {
        List<Car> cars = new ArrayList<>();
        for (int carPosition : carPositions) {
            cars.add(Car.of(carPosition));
        }
        return Cars.of(cars);
    }

    private List<Position> expectedPositions(int[] carPositions, boolean move) {
        return Arrays.stream(carPositions)
                .mapToObj(position -> Position.of(position + (move ? 1 : 0)))
                .collect(Collectors.toList());
    }

}
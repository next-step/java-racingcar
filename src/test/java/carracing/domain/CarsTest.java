package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest(name = "입력 값에 따라 자동차 목록 내 모든 자동차가 한번씩 움직인다.")
    @ValueSource(ints = {0, 3, 4, 9})
    public void carsMoveTest(int mockRandomNumber) {
        List<Position> carPositions = createPositions(1, 3, 5);
        Cars cars = createCars(carPositions);
        cars.move(() -> Number.of(mockRandomNumber));
        assertThat(cars.getPositions())
                .isEqualTo(expectedPositions(carPositions, mockRandomNumber > 3));
    }

    @DisplayName("위치를 기준으로 자동차를 그룹핑 할 수 있다.")
    @Test
    public void groupByPositionTest() {
        List<Position> carPositions = createPositions(1, 1, 3, 5);
        Cars cars = createCars(carPositions);
        Map<Position, List<Car>> carsGroupByPosition = cars.groupByPosition();
        for (Position position : carsGroupByPosition.keySet()) {
            assertThat(carsGroupByPosition.get(position))
                    .allMatch(car -> car.getPosition().equals(position))
                    .size()
                    .isEqualTo(expectSize(carPositions, position));
        }
    }

    private long expectSize(List<Position> positions, Position expected) {
        return positions.stream()
                .filter(position -> position.equals(expected))
                .count();
    }

    private List<Position> createPositions(int... positions) {
        return Arrays.stream(positions)
                .mapToObj(position -> Position.of(position))
                .collect(Collectors.toList());
    }

    private Cars createCars(List<Position> carPositions) {
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<carPositions.size(); ++i) {
            cars.add(Car.of(carPositions.get(i), CarName.of("car"+i)));
        }
        return Cars.of(cars);
    }

    private List<Position> expectedPositions(List<Position> carPositions, boolean move) {
        return carPositions.stream()
                .map(position -> move ? position.next() : position)
                .collect(Collectors.toList());
    }
}
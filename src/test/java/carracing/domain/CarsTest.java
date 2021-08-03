package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        List<Position> carPositions = createPositions(1, 3, 5);
        Cars cars = Cars.of(createCars(carPositions));
        cars.move(() -> Number.of(mockRandomNumber));
        assertThat(cars.getPositions())
                .isEqualTo(expectedPositions(carPositions, mockRandomNumber > 3));
    }

    @DisplayName("우승자를 추출 할 수 있다.")
    @Test
    public void groupByPositionTest() {
        List<Car> losers = createCars(createPositions(1, 1, 3, 5));
        List<Car> winners = createCars(createPositions(6, 6));
        Cars cars = Cars.of(allOf(losers, winners));
        assertThat(cars.getWinners()).isEqualTo(winners);
    }

    private List<Car> allOf(List<Car> losers, List<Car> winners) {
        List<Car> all = new ArrayList<>();
        all.addAll(losers);
        all.addAll(winners);
        return all;
    }

    private List<Position> createPositions(int... positions) {
        return Arrays.stream(positions)
                .mapToObj(position -> Position.of(position))
                .collect(Collectors.toList());
    }

    private List<Car> createCars(List<Position> carPositions) {
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<carPositions.size(); ++i) {
            cars.add(Car.of(carPositions.get(i), CarName.of("car"+i)));
        }
        return cars;
    }

    private List<Position> expectedPositions(List<Position> carPositions, boolean move) {
        return carPositions.stream()
                .map(position -> move ? position.next() : position)
                .collect(Collectors.toList());
    }
}
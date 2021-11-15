package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("Cars 단위 테스트")
public class CarsTest {

    private static final int GO_VALUE = 4;

    private final List<String> carNames = Arrays.asList("1", "2", "3");

    @Test
    @DisplayName("4단계 - 우승자 - 우승자 추출 - 1명")
    void extractWinners() {
        List<Integer> carMovingDistances = Arrays.asList(3, 2, 1);
        List<Car> cars = createMockCars(carNames, carMovingDistances);
        Cars firstCars = new Cars(cars);

        List<Car> actualWinners = firstCars.findWinners();

        assertThat(actualWinners)
                .containsExactlyElementsOf(cars.subList(0, 1));
    }

    @Test
    @DisplayName("4단계 - 우승자 - 우승자 추출 - 2명")
    void extractWinnersTwo() {
        List<Integer> carMovingDistances = Arrays.asList(3, 3, 1);
        List<Car> cars = createMockCars(carNames, carMovingDistances);
        Cars firstCars = new Cars(cars);

        List<Car> actualWinners = firstCars.findWinners();

        assertThat(actualWinners)
                .containsExactlyElementsOf(cars.subList(0, 2));
    }

    private List<Car> createMockCars(List<String> names, List<Integer> movingDistances) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            Car car = new Car(names.get(i));
            go(car, movingDistances.get(i));
            cars.add(car);
        }
        return cars;
    }

    private void go(Car car, int numberOfMove) {
        for (int i = 0; i < numberOfMove; i++) {
            car.move(GO_VALUE);
        }
    }

    @Test
    void moveAll() {
        List<Car> cars = Arrays.asList(new Car(""), new Car(""));
        Cars firstCars = new Cars(cars);
        RandomGenerator randomGenerator = new RandomGenerator(10);

        assertThatCode(() -> firstCars.moveAll(randomGenerator))
                .doesNotThrowAnyException();
    }
}

package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveType;
import racingcar.domain.Name;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("중복된 이름의 차량이 있을 경우 예외 발생")
    void testDuplicateNameCars() {
        List<String> carNames = List.of("test", "test1", "test");

        assertThatThrownBy(() -> new Cars(makeCars(carNames))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승 차량 테스트")
    void testWinnerCars() {
        List<String> carNames = List.of("test1", "test2", "test3", "test4");
        List<String> winnerNames = List.of("test3", "test4");
        List<Integer> carPositions = List.of(0, 1, 3, 3);

        Cars cars = makeCars(carNames, carPositions);
        List<Car> winnerCars = cars.getWinnerCars();

        assertThat(winnerCars).hasSize(2);

        for (int i = 0; i < winnerCars.size(); i++) {
            Car winnerCar = winnerCars.get(i);
            Name winnerName = winnerCar.getName();
            assertThat(winnerName.getName()).isEqualTo(winnerNames.get(i));
        }
    }

    private Car makeCar(String name, int position) {
        Car car = new Car(name);

        for (int i = 0; i < position; i++) {
            car.move(MoveType.FORWARD);
        }

        return car;
    }

    private List<Car> makeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private Cars makeCars(List<String> carNames, List<Integer> carPositions) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            cars.add(makeCar(carNames.get(i), carPositions.get(i)));
        }

        return new Cars(cars);
    }
}

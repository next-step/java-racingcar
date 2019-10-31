package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class RacersTest {

    @Test
    @DisplayName("Racers의 moveAll을 했을때 move가 호출되는지 획인한다.")
    void moveAll() {
        List<Car> cars = getMockCars();
        Racers racers = new Racers(cars);
        int expectInvocationCount = 1;

        racers.moveAll();

        for (Car car : cars) {
            verify(car, times(expectInvocationCount)).move(anyInt());
        }
    }

    private List<Car> getMockCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(mock(Car.class));
        cars.add(mock(Car.class));
        cars.add(mock(Car.class));

        return cars;
    }

    @Test
    @DisplayName("정해진 우승자가 나오는지 테스트")
    void winner() {
        List<Car> cars = getCars();
        Car expectedCar = getExpectedCar();
        cars.add(expectedCar);
        Racers racers = new Racers(cars);

        assertThat(racers.winner()).containsExactly(expectedCar.getName());
    }

    private Car getExpectedCar() {
        Car expectedCar = new Car("dave");
        expectedCar.move(9);
        expectedCar.move(9);
        expectedCar.move(9);

        return expectedCar;
    }

    private List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));

        return cars;
    }
}

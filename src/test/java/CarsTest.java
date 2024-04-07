import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
    private Cars cars = new Cars();

    @Test
    @DisplayName("position이_가장큰_자동차가_우승자")
    void position이_가장큰_자동차가_우승자() {
        Car car1 = new Car("red", 3);
        Car car2 = new Car("blue", 5);

        List<Car> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);

        assertThat(cars.judgeWinner(list)).isEqualTo("blue ");
    }

    @Test
    @DisplayName("공동우승")
    void 공동우승() {
        Car car1 = new Car("red", 5);
        Car car2 = new Car("blue", 5);

        List<Car> list = Arrays.asList(car1, car2);

        assertThat(cars.judgeWinner(list)).isEqualTo("red blue ");
    }

    @Test
    @DisplayName("이름중복시_예외발생")
    void 이름중복시_예외발생() {
        Car car1 = new Car("red", 5);
        Car car2 = new Car("blue", 5);
        Car car3 = new Car("red", 5);

        List<Car> list = Arrays.asList(car1, car2, car3);

        assertThrows(IllegalArgumentException.class, () -> {
            cars.validateCar(list);
        });
    }
}

package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void checkNumberOfCars() {
        String[] carNameArr = new String[]{"gglee", "jhkim", "mskim"};
        Cars cars = new Cars(carNameArr);
        assertThat(cars.getCars().size()).isEqualTo(carNameArr.length);
    }

    @Test
    void checkMaxPosition() {
        List<Car> carList = Arrays.asList(new Car("gglee", 1),
                                            new Car("jhkim", 2),
                                            new Car("mskim", 3));
        Cars cars = new Cars(carList);
        assertThat(cars.getMaxPosition().getPosition()).isEqualTo(3);
    }

    @Test
    void checkWinners() {
        Car car1 = new Car("gglee", 1);
        Car car2 = new Car("jhkim", 2);
        Car car3 = new Car("mskim", 5);
        Car car4 = new Car("julee", 5);

        List<Car> carList = Arrays.asList(car1, car2, car3, car4);
        Cars cars = new Cars(carList);
        List<Car> winners = cars.getWinners();
        assertThat(winners).contains(car3, car4);
    }
}

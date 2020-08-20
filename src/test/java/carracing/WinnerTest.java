package carracing;

import carracing.domain.car.Car;
import carracing.domain.car.strategy.CarPowerCondition;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerTest {

    @Test
    void int_배열() {
        int[] position = new int[3];
        position[0] = 2;
        position[1] = 2;
        position[2] = 1;
    }

    @Test
    void stream_테스트() {

        int maxPosition = 1;

        Car car1 = new Car("car1");
        car1.setPosition(new CarPowerCondition());
        car1.setPosition(new CarPowerCondition());
        car1.setPosition(new CarPowerCondition());

        Car car2 = new Car("car2");
        car2.setPosition(new CarPowerCondition());
        car2.setPosition(new CarPowerCondition());
        car2.setPosition(new CarPowerCondition());

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        String name = cars.stream()
                .filter(car -> maxPosition <= car.getPosition())
                .map(Car::getCarName)
                .collect(Collectors.joining(","));

        assertThat(name).isNotBlank();
    }
}

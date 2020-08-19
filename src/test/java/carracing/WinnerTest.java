package carracing;

import carracing.domain.car.Car;
import carracing.domain.car.strategy.CarPowerCondition;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        car1.setPosition(new CarPowerCondition(car1.getPower()));
        car1.setPosition(new CarPowerCondition(car1.getPower()));
        car1.setPosition(new CarPowerCondition(car1.getPower()));

        Car car2 = new Car("car2");
        car2.setPosition(new CarPowerCondition(car2.getPower()));
        car2.setPosition(new CarPowerCondition(car2.getPower()));
        car2.setPosition(new CarPowerCondition(car2.getPower()));

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        String name = cars.stream()
                .filter(car -> maxPosition <= car.getPosition())
                .flatMap(car -> Stream.of(car.getCarName()))
                .collect(Collectors.joining(","));
        System.out.println(name);


    }
}

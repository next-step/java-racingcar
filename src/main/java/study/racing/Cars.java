package study.racing;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private static List<Car> cars;

    public Cars(int carCnt) {
        this.cars = IntStream.range(0, carCnt)
                .mapToObj(car -> new Car())
                .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(car -> {
                    car.move(car.getRandomInt());
                }
        );
    }

    public List<Car> getCarSet() {
        return cars;
    }
}

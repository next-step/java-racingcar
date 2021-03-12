package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCar(String[] names, int initPosition) {
        Arrays.stream(names)
            .forEach(name -> cars.add(new Car(name, initPosition)));
    }

    public void move(Limit limit) {
        cars.forEach(car -> {
            boolean move = car.isMove(RandomUtil.nextInt(RandomUtil.BOUND10), limit.getLimit());
            car.move(move);
        });
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> getWinners() {
        Car max = getMaxPosition();

        return cars.stream()
            .filter(car -> car.getPosition() == max.getPosition())
            .collect(Collectors.toList());
    }

    private Car getMaxPosition() {
        return cars.stream()
            .max(Car::compareTo)
            .get();
    }
}

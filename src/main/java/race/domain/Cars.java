package race.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import utils.number.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    private Cars(int countOfCar) {
        cars = generateCar(countOfCar);
    }

    private Cars(String[] names) {
        cars = generateCar(names);
    }

    public static Cars createInstance(int countOfCar) {
        return new Cars(countOfCar);
    }

    public static Cars createInstance(String[] names) {
        return new Cars(names);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getSize() {
        return cars.size();
    }

    public void moveCars(NumberGenerator generator) {
        for (Car car : cars) {
            car.move(generator.generate());
        }
    }

    public List<Car> chooseWinners() {
        Car winner = chooseWinner();
        return this.cars.stream()
                .filter(winner::isEqualPosition)
                .collect(Collectors.toList());
    }

    private Car chooseWinner() {
        TreeSet<Car> cars = new TreeSet<>(this.cars);
        return cars.last();
    }

    private List<Car> generateCar(int countOfCar) {
        List<Car> cars = new ArrayList<>();

        while (countOfCar > 0) {
            cars.add(Car.createInstance("test"));
            countOfCar--;
        }

        return cars;
    }

    private List<Car> generateCar(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(Car.createInstance(name));
        }

        return cars;
    }
}

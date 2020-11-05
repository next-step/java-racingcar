package racingcar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarGroup {

    private List<Car> cars;

    public CarGroup(String nameCsv, MoveStrategy strategy) {
        String[] nameArr = nameCsv.split(CarGroupConst.NAME_SPLIT_REGEX);
        cars = Arrays.stream(nameArr)
                .map(name -> Car.createCar(name, strategy))
                .collect(Collectors.toList());
    }

    public void moveCar() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Memento createMemento() {
        Memento memento = new Memento();
        for (Car car : cars) {
            memento.addCar(car.clone());
        }
        return memento;
    }

    public void restoreMemento(Memento memento) {
        cars = memento.getCars();
    }

    protected List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    protected List<Car> getWinners(List<Car> cars) {
        return cars.stream()
                .collect(
                        Collectors.groupingBy(Car::getPosition)
                ).entrySet()
                .stream()
                .max(
                        Comparator.comparing(Map.Entry::getKey)
                ).get()
                .getValue();
    }

    public List<Car> getWinners() {
        return getWinners(cars);
    }

    public void setStrategy(MoveStrategy strategy) {
        for (Car car : cars) {
            car.setStrategy(strategy);
        }
    }
}

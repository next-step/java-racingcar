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
        this.cars = Arrays.stream(nameArr)
                .map(name -> new Car(name, strategy))
                .collect(Collectors.toList());
    }

    public void moveCar() {
        for (Car car : this.cars) {
            car.move();
        }
    }

    public Memento createMemento() {
        Memento memento = new Memento();
        for (Car car : this.cars) {
            memento.addCar(new Car(car));
        }
        return memento;
    }

    public void restoreMemento(Memento memento) {
        this.cars = memento.getCars();
    }

    protected List<Integer> getPositions() {
        return this.cars.stream()
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
        return this.getWinners(this.cars);
    }

    public void setStrategy(MoveStrategy strategy) {
        for (Car car : this.cars) {
            car.setStrategy(strategy);
        }
    }
}

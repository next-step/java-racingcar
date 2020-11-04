package racingcar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
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

    private void print(List<Car> cars, Consumer<List<Car>> consumer) {
        consumer.accept(cars);
    }

    public void print(Consumer<List<Car>> consumer) {
        this.print(this.cars, consumer);
    }

    protected List<Integer> getPositions() {
        return this.cars.stream()
                .map(Car::getPosition())
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

    public void printWinners(Consumer<List<Car>> consumer) {
        List<Car> winners = this.getWinners(this.cars);
        this.print(winners, consumer);
    }
}

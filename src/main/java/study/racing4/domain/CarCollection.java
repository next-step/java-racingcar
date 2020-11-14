package study.racing4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CarCollection {

    private List<Car> cars;

    public CarCollection(String[] cars) {
        this.cars = initRacingRecords(cars);
    }

    public CarCollection(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> initRacingRecords(String[] carNames) {

        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public int getMaxPosition() {
        int maxPosition = 0;

        for (Car car: cars) {
            if(car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<Car> matchedPositionCars(int maxPosition) {

        return cars.stream()
                .filter( car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public void apply(Consumer<Car> consumer) {
        cars.forEach(consumer);
    }
}

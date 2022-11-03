package racing.domain;

import racing.strategy.MoveStrategy;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class Cars {

    private List<Car> cars;
    private String[] carNames;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] carNames) {
        this.cars = createCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i]));
        }
        return carList;
    }

    public void moveEvent(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getWinners() {
        Set<Map.Entry<Integer, List<Car>>> groupCars = cars.stream()
                .collect(groupingBy(Car::getDistance))
                .entrySet();

        return groupCars.stream().max(Comparator.comparing(Map.Entry::getKey))
                .get()
                .getValue();
    }
}

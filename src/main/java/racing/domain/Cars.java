package racing.domain;

import racing.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private List<Car> cars;

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
        Arrays.stream(carNames)
                .forEach(i -> carList.add(new Car(i)));
        return carList;
    }

    public void move(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getWinners() {
        return new Winner().getWinners(cars);
    }
}

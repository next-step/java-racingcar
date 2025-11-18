package racingCar;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private final List<Car> cars;
    private final RandomNumber random;

    public CarRace(String[] names) {
        random = new RandomNumber();
        cars = createCars(names);
    }
    private static List<Car> createCars(String[] names) {
        List<Car> carList = new ArrayList<>();
        for(String name : names) {
            carList.add(new Car(name));
        }

        return carList;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void play() {
        for (Car car : this.cars) {
            car.move(getRandomNum());
        }
    }

    public List<Car> getWinners() {
        return Winners.getWinners(cars);
    }

    private int getRandomNum() {
        return random.getRandomNum();
    }

    public int carNos() {
        return this.cars.size();
    }
}

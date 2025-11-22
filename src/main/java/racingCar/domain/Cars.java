package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private final RandomNumber random;

    public Cars(String[] names) {
        this(createCars(names));
    }

    public Cars(List<Car> cars) {
        random = new RandomNumber();
        this.cars = cars;
    }

    public List<Car> value() {
        return cars;
    }

    private static List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public Winners getWinners() {
        return new Winners(getWinners(getMaxDistance()));
    }

    private List<Car> getWinners(Distance maxDistance) {
        List<Car> winners = new ArrayList<>();

        for(Car car : this.cars) {
            if(car.isMax(maxDistance)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private Distance getMaxDistance() {
        Distance max = new Distance();
        for(Car car : this.cars) {
            max = car.max(max);
        }
        return max;
    }

    public void play() {
        for (Car car : this.cars) {
            car.move(getRandomNum());
        }
    }

    private int getRandomNum() {
        return random.getRandomNum();
    }
}

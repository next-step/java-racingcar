package racingCar.model;

import racingCar.utils.RandomUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;
    private int playCount;

    public Cars(String[] carNames, int playCount) {
        this.cars = makeCars(carNames);
        this.playCount = playCount;
    }

    private List<Car> makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<Car> moveCars() {
        for (Car car : cars) {
            car.move(new RandomMovingStrategy());
        }
        return cars;
    }

    private int findMaxLocation() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .orElseThrow(() -> new NoSuchElementException())
                .getLocation();
    }

    public List<Car> findWinners() {
        int maxLocation = findMaxLocation();
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .collect(Collectors.toList());
    }

    public int getPlayCount() {
        return playCount;
    }

    public List<Car> getCars() {
        return cars;
    }

}

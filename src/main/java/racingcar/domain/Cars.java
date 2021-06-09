package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private int cycle;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCars(String carName) {
        cars.add(new Car(carName));
    }

    public List<Car> selectWinners() {
        int winnerScore = selectWinnerScore(this.cars);

        return this.cars.stream()
                .filter(cars -> cars.isWinner(winnerScore))
                .map(cars -> new Car(cars.getName()))
                .collect(Collectors.toList());
    }

    private int selectWinnerScore(List<Car> carInfo) {
        return carInfo.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .get()
                .getLocation();
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCycle() {
        return cycle;
    }
}

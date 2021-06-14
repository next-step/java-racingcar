package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCars(String carName) {
        cars.add(new Car(carName));
    }

    public List<Car> selectWinners() {
        int winnerScore = selectWinnerScore(this.cars);

        return this.cars.stream()
                .filter(car -> car.isWinner(winnerScore))
                .collect(Collectors.toList());
    }

    private int selectWinnerScore(List<Car> carInfo) {
        return carInfo.stream()
                .mapToInt(Car::getLocation)
                .max()
                .getAsInt()
                ;
    }

    public List<Car> getCars() {
        return cars;
    }
}

package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private Cars cars = new Cars();

    public Cars createCarInformation(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            cars.add(carName);
        }
        return cars;
    }

    public List<Car> selectWinners() {
        int winnerScore = selectWinnerScore(this.cars.getCars());

        return this.cars.getCars().stream()
                .filter(cars -> cars.compareWinnerScore(winnerScore))
                .map(cars -> new Car(cars.getName()))
                .collect(Collectors.toList());
    }

    private int selectWinnerScore(List<Car> carInfo) {
        return carInfo.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .get()
                .getLocation();
    }
}

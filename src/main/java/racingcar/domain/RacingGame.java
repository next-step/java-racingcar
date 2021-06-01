package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> carInfo = new ArrayList<>();

    public List<Car> createCarInformation(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            carInfo.add(car);
        }
        return carInfo;
    }

    public List<Car> selectWinners() {
        int winnerScore = selectWinnerScore(this.carInfo);

        return this.carInfo.stream()
                .filter(car -> car.compareWinnerScore(winnerScore))
                .map(car -> new Car(car.getName()))
                .collect(Collectors.toList());
    }

    private int selectWinnerScore(List<Car> carInfo) {
        return carInfo.stream()
                .max(Comparator.comparingInt(Car::getLocationInfo))
                .get()
                .getLocationInfo();
    }
}

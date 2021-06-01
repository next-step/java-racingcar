package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private Car car = new Car();

    public Car createCarInformation(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            car.add(carName);
        }
        return car;
    }

    public List<Cars> selectWinners() {
        int winnerScore = selectWinnerScore(this.car.getCars());

        return this.car.getCars().stream()
                .filter(cars -> cars.compareWinnerScore(winnerScore))
                .map(cars -> new Cars(cars.getName()))
                .collect(Collectors.toList());
    }

    private int selectWinnerScore(List<Cars> carsInfo) {
        return carsInfo.stream()
                .max(Comparator.comparingInt(Cars::getLocationInfo))
                .get()
                .getLocationInfo();
    }
}

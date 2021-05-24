package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

    public List<Winner> selectWinners(List<Car> carInfo) {
        int winnerScore = selectWinnerScore(carInfo);

        return carInfo.stream()
                .filter(car -> car.compareWinnerScore(winnerScore))
                .map(car -> new Winner(car.getName()))
                .collect(Collectors.toList());
    }

    private int selectWinnerScore(List<Car> carInfo) {
        return carInfo.stream()
                .max(Comparator.comparingInt(Car::getLocationInfo))
                .get()
                .getLocationInfo();
    }
}

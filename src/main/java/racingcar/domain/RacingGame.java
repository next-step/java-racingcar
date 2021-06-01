package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Cars> carsInfo = new ArrayList<>();

    public List<Cars> createCarInformation(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            Cars cars = new Cars(carName);
            carsInfo.add(cars);
        }
        return carsInfo;
    }

    public List<Cars> selectWinners() {
        int winnerScore = selectWinnerScore(this.carsInfo);

        return this.carsInfo.stream()
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

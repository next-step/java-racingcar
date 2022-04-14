package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceRecord {
    private static final String CARS_DELIMITER = ",";
    private final List<Cars> raceResult;

    public RaceRecord() {
        this.raceResult = new ArrayList<>();
    }

    public void addRecord(Cars cars) {
        raceResult.add(cars);
    }

    public int getSize() {
        return raceResult.size();
    }

    public String getRecord() {
        String record = "";
        for (Cars cars : raceResult) {
            record += cars.toString();
        }
        return record;
    }

    public String getRaceWinners() {
         return findRaceWinners(raceResult.get(raceResult.size() - 1));
    }

    private Car getCurrentWinner(Cars cars) {
        if (cars.checkSize()) {
            cars.reverseSortCarsFromPosition();
            return cars.getCurrentWinner();
        }
        throw new IllegalArgumentException("Car List 에는 한건 이상의 데이터가 있어야 합니다.");
    }

    private String findRaceWinners(Cars cars) {
        Car winner = getCurrentWinner(cars);
        List<String> winners = cars.findRaceWinners(winner)
                .stream()
                .map(Car::carName)
                .collect(Collectors.toList());
        return String.join(CARS_DELIMITER, winners);
    }

}

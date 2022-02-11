package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceResults {

    private final List<List<Car>> raceResults;

    public RaceResults(List<List<Car>> raceResults) {
        this.raceResults = new ArrayList<>(raceResults);
    }

    public List<String> findWinners() {
        List<Car> lastRaceResult = raceResults.get(raceResults.size() - 1);
        int maxPosition = findMaxPosition(lastRaceResult);
        return findCarsWithMaxPosition(lastRaceResult, maxPosition);
    }

    private int findMaxPosition(List<Car> carsAfterRace) {
        int maxPosition = 0;
        for (Car car : carsAfterRace) {
            maxPosition = car.compareMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<String> findCarsWithMaxPosition(List<Car> carsAfterRace, int position) {
        List<String> winners = new ArrayList<>();
        for (Car car : carsAfterRace) {
            findCarWithSamePosition(car, position, winners);
        }
        return winners;
    }

    private void findCarWithSamePosition(Car car, int position, List<String> winners) {
        if (car.isSamePosition(position)) {
            winners.add(car.getCarName());
        }
    }

    public List<List<Car>> getRaceResults() {
        return raceResults;
    }
}

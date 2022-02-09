package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceResults {

    private final List<RaceResult> raceResults;
    private final RaceResult lastRaceResult;
    private final List<String> winners;
    private int maxPosition;

    public RaceResults(List<RaceResult> raceResults) {
        this.raceResults = raceResults;
        this.lastRaceResult = raceResults.get(raceResults.size() - 1);
        this.winners = new ArrayList<>();
        this.maxPosition = 0;
    }

    public List<String> findWinners() {
        List<Car> carsAfterLastRace = lastRaceResult.getRaceResultByRound();
        findMaxPosition(carsAfterLastRace);
        findCarsWithMaxPosition(carsAfterLastRace);
        return winners;
    }

    public void findMaxPosition(List<Car> carsAfterRace) {
        for (Car car : carsAfterRace) {
            maxPosition = car.compareMaxPosition(maxPosition);
        }
    }

    private void findCarsWithMaxPosition(List<Car> carsAfterRace) {
        for (Car car : carsAfterRace) {
            findCarWithSamePosition(car);
        }
    }

    private void findCarWithSamePosition(Car car) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car.getCarName());
        }
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }
}

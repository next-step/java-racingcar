package car.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResults {
    private List<RaceResult> raceResults;

    public RaceResults() {
        raceResults = new ArrayList<>();
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }

    void addRaceResult(RaceResult raceResult) {
        raceResults.add(raceResult);
    }

    RaceResult getLastResult() {
        int lastIndex = raceResults.size() - 1;

        return raceResults.get(lastIndex);
    }

    public StringBuilder getWinners() {
        StringBuilder winners = new StringBuilder();
        int maxKm = 0;

        int lastIndex = raceResults.size() - 1;
        List<Car> cars = raceResults.get(lastIndex).getCars();

        for (Car car : cars) {
            maxKm = Math.max(maxKm, car.getKm());
        }

        for (Car car : cars) {
            winners.append(getWinner(car, maxKm));
        }

        return winners;
    }

    public String getWinner(Car car, int max) {
        if (car.getKm() == max)
            return car.getName() + ", ";
        return "";
    }
}

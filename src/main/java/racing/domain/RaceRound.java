package racing.domain;

import java.util.List;

public class RaceRound {

    private final List<RaceResult> raceResults;

    public RaceRound(List<RaceResult>  raceResults) {
        this.raceResults = raceResults;
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }

    public int getRoundCount() {
        return raceResults.size();
    }

    public RaceResult findResult(int index) {
        return raceResults.get(index);
    }

    private int getMaxPosition() {
        List<Car> cars = findResult(getRoundCount()-1).getResultCars();
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max().getAsInt();
    }

    public String[] getWinners() {
        List<Car> cars = findResult(getRoundCount()-1).getResultCars();
        return cars.stream()
                .filter(car -> car.getDistance() == getMaxPosition())
                .map(Car::getName)
                .toArray(String[]::new);
    }


}

package car_racing;

import java.util.*;

public class CarRacingResultHistory {

    private final List<List<CarRacingResult>> racingResults;
    private final Cars winners;

    public CarRacingResultHistory() {
        this.racingResults = new ArrayList<>();
        this.winners = new Cars();
    }

    public void update(Cars cars) {
        if (Objects.isNull(cars)) {
            return;
        }
        List<CarRacingResult> currCarRacingResults = makeListOfCurrRacingResult(cars);

        racingResults.add(currCarRacingResults);
    }

    private List<CarRacingResult> makeListOfCurrRacingResult(Cars cars) {
        List<CarRacingResult> currRacingResult = new ArrayList<>();

        for (Car car: cars.getCars()) {
            currRacingResult.add(buildRacingResult(car.getStringName(), car.getPosition()));
        }

        return currRacingResult;
    }

    private CarRacingResult buildRacingResult(String name, int position) {
        return new CarRacingResult(name, position);
    }

    public List<List<CarRacingResult>> getRacingResults() {
        return racingResults;
    }

    public void updateWinners(Cars cars) {
        int maxPosition = -1;

        for(Car car : cars.getCars()) {
            maxPosition = calMaxPosition(car, maxPosition);
        }

        for(Car car: cars.getCars()) {
            updateWinners(car, maxPosition);
        }
    }

    private int calMaxPosition(Car car, int maxPosition) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }

    private void updateWinners(Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }

    public Cars getWinners() {
        return winners;
    }

}

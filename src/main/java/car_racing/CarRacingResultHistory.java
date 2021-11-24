package car_racing;

import java.util.*;

public class CarRacingResultHistory {

    private final List<List<CarRacingResult>> racingResults;
    private List<Car> winners;

    public CarRacingResultHistory() {
        this.racingResults = new ArrayList<>();
    }

    public void update(CarsForGame carsForGame) {
        if (Objects.isNull(carsForGame)) {
            return;
        }
        List<CarRacingResult> currCarRacingResults = makeListOfCurrRacingResult(carsForGame);

        racingResults.add(currCarRacingResults);
    }

    private List<CarRacingResult> makeListOfCurrRacingResult(CarsForGame carsForGame) {
        List<CarRacingResult> currRacingResult = new ArrayList<>();

        for (Car car: carsForGame.getCars()) {
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

    public void updateWinners(List<Car> winners) {
        this.winners = winners;
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

    public List<Car> getWinners() {
        return winners;
    }

}

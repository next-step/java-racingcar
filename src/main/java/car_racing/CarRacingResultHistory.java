package car_racing;

import java.util.*;

public class CarRacingResultHistory {

    private final List<List<CarRacingResult>> racingResults;

    public CarRacingResultHistory() {
        this.racingResults = new ArrayList<>();
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
}

package car_racing;

import java.util.*;

public class CarRacingResult {

    private final List<List<Integer>> racingResult;

    public CarRacingResult() {
        this.racingResult = new ArrayList<>();
    }

    public void update(Cars cars) {
        if (Objects.isNull(cars)) {
            return;
        }

        List<Integer> currCarPositions = getCurrCarPositions(cars);

        racingResult.add(currCarPositions);
    }

    public List<List<Integer>> getRacingResult() {
        return racingResult;
    }

    private List<Integer> getCurrCarPositions(Cars cars) {
        List<Integer> currCarPositions = new ArrayList<>();

        for (Car car : cars.getCars()) {
            currCarPositions.add(car.getPosition());
        }

        return currCarPositions;
    }
}

package car_racing;

import java.util.*;

public class CarRacingResult {

    private final List<Cars> racingResult;

    public CarRacingResult() {
        this.racingResult = new ArrayList<>();
    }

    public void update(Cars cars) {
        if (Objects.isNull(cars)) {
            return;
        }

        racingResult.add(cars);
    }

    private List<Integer> makeListOfCurrPositions(Cars cars) {
        List<Integer> currCarPositions = new ArrayList<>();

        for (Car car : cars.getCars()) {
            currCarPositions.add(car.getPosition());
        }

        return currCarPositions;
    }

    public List<Cars> getRacingResult() {
        return racingResult;
    }

}

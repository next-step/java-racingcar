package car_racing;

import java.util.*;

public class CarRacingResult {

    private static final String ONE_ROUND_END_SIGNAL = "\n";
    private static final int MIN_CURR_RESULT_SIZE = 1;

    private final List<StringBuilder> currResult;
    private final StringBuilder finalResult;

    public CarRacingResult() {
        currResult = new ArrayList<>();
        finalResult = new StringBuilder();
    }

    public void update(Cars cars) {
        if (Objects.isNull(cars)) {
            return;
        }

        if (uninitialized()) {
            initCurrResult(cars.numberOfCars());
        }

        for(Car car: cars.getCars()) {
            updateToCurrResult(car);
        }

        updateToFinalResult();
    }

    public String show() {
        return finalResult.toString();
    }

    private void updateToCurrResult(Car car) {
        Status status = car.getCurrStatus();
        currResult.get(car.getId()).append(status.signal);
    }

    private void updateToFinalResult() {
        for(StringBuilder result: currResult) {
            finalResult.append(result).append(ONE_ROUND_END_SIGNAL);
        }
        finalResult.append(ONE_ROUND_END_SIGNAL);
    }


    private void initCurrResult(int numberOfCars) {
        while (numberOfCars --> 0) {
            currResult.add(new StringBuilder());
        }
    }

    private boolean uninitialized() {
        return currResult.size() < MIN_CURR_RESULT_SIZE;
    }
}

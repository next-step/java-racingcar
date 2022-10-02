package racingcar;

import java.util.ArrayList;
import java.util.List;

public class TrialCount {
    public static final int MIN_COUNT = 1;

    private final int count;

    public TrialCount(int count) {
        validateNumberOverMinimum(count);
        this.count = count;
    }

    private void validateNumberOverMinimum(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상 입니다.");
        }
    }

    public List<Cars> start(Cars initializedCars) {
        Cars cars = initializedCars;
        List<Cars> trials = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars = cars.nextTrial();
            trials.add(cars);
        }
        return trials;
    }
}

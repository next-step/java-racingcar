package racingcar;

import java.util.ArrayList;
import java.util.List;

public final class RacingCar {
    private static final MovingStrategy RANDOM_MOVING_STRATEGY = new RandomMovingStrategy();
    private final Cars cars;
    private final int roundCount;

    public RacingCar(int carCount, int roundCount) {
        validate(carCount, roundCount);

        this.roundCount = roundCount;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        this.cars = new Cars(cars);
    }

    private void validate(int carCount, int roundCount) {
        if (carCount <= 0) {
            throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다. 입력 값 : " + carCount);
        }
        if (roundCount < 0) {
            throw new IllegalArgumentException("주어진 횟수는 0 이상이어야 합니다. 입력 값 : " + roundCount);
        }
    }

    public ArrayList<Cars> play() {
        ArrayList<Cars> results = new ArrayList<>();
        for (int count = 0; count < roundCount; count++) {
            playAndAdd(results);
        }
        return results;
    }
    private void playAndAdd(List<Cars> results) {
        if(results.isEmpty()) {
            results.add(cars.play(RANDOM_MOVING_STRATEGY));
            return;
        }

        Cars currentCars = results.get(results.size()-1);
        results.add(currentCars.play(RANDOM_MOVING_STRATEGY));
    }
}

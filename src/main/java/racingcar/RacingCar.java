package racingcar;

import java.util.ArrayList;
import java.util.List;

public final class RacingCar {
    private final Cars cars;
    private final int roundCount;

    public RacingCar(int carCount, int roundCount) {
        validate(carCount, roundCount);

        this.roundCount = roundCount;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            Car car = new Car(roundCount);
            cars.add(car);
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

    public ArrayList<ArrayList<Integer>> play() {
        int count = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (count < roundCount) {
            cars.play();
            result.add(new ArrayList<>(cars.result()));
            count++;
        }
        return result;
    }
}

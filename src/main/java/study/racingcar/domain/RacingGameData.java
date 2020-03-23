package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameData {
    private static final int MIN = 1;
    private List<Car> cars;
    private int time;

    public RacingGameData(List<String> carNames, int time) {
        if (time < MIN) {
            throw new IllegalArgumentException(
                    String.format("시도 횟수는 %d 이상이여야 합니다.", MIN));
        }
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("한대 이상의 차가 있어야 합니다.");
        }

        initCars(carNames);
        this.time = time;
    }

    private void initCars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTime() {
        return time;
    }
}

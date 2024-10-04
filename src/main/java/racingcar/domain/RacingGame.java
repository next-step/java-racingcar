package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            car.run(CarMoveUtil.isMove());
        }
    }

    public List<Car> getWinners() {
        // max position 조회
        int max = 0;
        for (Car car : cars) {
            max = car.max(max);
        }

        final int finalMax = max;

        return cars.stream().filter(car -> car.isSamePosition(finalMax)).collect(Collectors.toList());
    }

    public Map<String, Integer> getRaceResult() {
        Map<String, Integer> raceResult = new HashMap<>();
        for (Car car : cars) {
            raceResult.put(car.getName(), car.getCurrentPosition());
        }
        return raceResult;
    }
}

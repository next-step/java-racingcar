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

        Integer max = cars.stream().map(Car::getCurrentPosition).max(Integer::compare).orElseThrow(()-> new IllegalArgumentException("우승자가 존재하지 않습니다."));

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

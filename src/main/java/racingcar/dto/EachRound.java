package racingcar.dto;

import racingcar.domain.Car;

import java.util.HashMap;
import java.util.Map;

public class EachRound {

    private Map<String, Integer> result = new HashMap<>();

    public Map<String, Integer> getResult() {
        return result;
    }

    public void recordRoundPosition(Car car) {
        result.put(car.getName(), car.getPosition());
    }
}

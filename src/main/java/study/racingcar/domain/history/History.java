package study.racingcar.domain.history;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import study.racingcar.domain.car.Car;

public class History {

    private final List<Map<Car, Integer>> history;

    public History(List<Map<Car, Integer>> result) {
        this.history = result;
    }

    public List<Map<Car, Integer>> history() {
        return history;
    }

    public List<String> winners() {
        Map<Car, Integer> map = this.history.get(lastIndexOfhistory());

        int maxValue = map.values().stream().max(Comparator.comparing(Integer::intValue))
            .orElseThrow(() -> new IllegalArgumentException("참여자를 찾을 수 없습니다."));

        return map.entrySet().stream()
            .filter(carStringEntry -> carStringEntry.getValue().equals(maxValue)).map(Entry::getKey)
            .map(Car::name).collect(Collectors.toList());
    }

    private int lastIndexOfhistory() {
        return this.history.size() - 1;
    }
}

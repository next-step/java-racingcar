package study.racingcar;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class History {

    private final LinkedList<Map<Car,String>> history;

    public History(LinkedList<Map<Car, String>> result) {
        this.history = result;
    }

    public List<Map<Car, String>> history() {
        return history;
    }

    public List<String> winners() {
        Map<Car, String> map = this.history.getLast();

        String maxValue = map.values().stream()
            .max(Comparator.comparing(String::length))
            .orElseThrow(() -> new IllegalArgumentException("참여자를 찾을 수 없습니다."));

        return map.entrySet().stream()
            .filter(carStringEntry -> carStringEntry.getValue().equals(maxValue))
            .map(Entry::getKey)
            .map(Car::name)
            .collect(Collectors.toList());
    }
}

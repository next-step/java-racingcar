package racinggame.core.scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import racinggame.core.Car;
import racinggame.exception.InvalidCarNameException;

public class Score {

    private final Map<String, Integer> scoreInfo = new LinkedHashMap<>();

    public void recordScore(List<Car> cars) {
        for (Car car : cars) {
            scoreInfo.put(car.getName(), car.getDistance());
        }
    }

    public Map<String, Integer> getAllScore() {
        return scoreInfo;
    }

    public Integer getScore(String name) {
        Integer distance = scoreInfo.get(name);
        if (distance == null) {
            throw new InvalidCarNameException();
        }
        return distance;
    }

    public List<String> getWinner() {
        List<Entry<String, Integer>> list = new ArrayList<>(scoreInfo.entrySet());
        list.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        int maxDistance = list.get(0)
                .getValue();

        return list.stream()
                .filter(entry -> entry.getValue() == maxDistance)
                .map(Entry::getKey)
                .collect(Collectors.toList());
    }

}

package racing.model;

import java.util.*;
import java.util.stream.Collectors;

public class RacingResult {

    private Map<String, Integer> result = new HashMap<>();

    public List<Map.Entry<String, Integer>> getResult() {
        return new ArrayList<>(result.entrySet());
    }

    public List<String> getWinners() {
        int winnerLocation = result.values().stream()
                .max(Comparator.naturalOrder()).orElse(0);

        return result.entrySet().stream()
                .filter(e -> e.getValue() == winnerLocation)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public void update(List<Car> cars) {
        cars.forEach(car -> result.put(car.getCarName(), car.currentLocation()));
    }


}

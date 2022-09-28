package racing.game.result;

import racing.game.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.max;

public class RoundResult {
    private final Map<String, Integer> roundCarHistory;

    public RoundResult() {
        this.roundCarHistory = new HashMap<>();
    }


    public Set<String> namesOfCar() {
        return roundCarHistory.keySet();
    }

    public int positionOfCar(String carName) {
        return roundCarHistory.get(carName);
    }

    public List<String> nameOfLeadingGroup() {
        Integer maxPosition = max(roundCarHistory.values());
        return leadingGroupNames(maxPosition);
    }

    public void addCarRoundResult(Car car) {
        roundCarHistory.put(car.name(), car.currentPosition());
    }


    private List<String> leadingGroupNames(Integer maxPosition) {
        return roundCarHistory.entrySet()
                .stream()
                .filter(entry -> isMaxPosition(maxPosition, entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private boolean isMaxPosition(Integer maxPosition, Integer carPosition) {
        return maxPosition.equals(carPosition);
    }
}

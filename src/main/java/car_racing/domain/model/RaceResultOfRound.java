package car_racing.domain.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceResultOfRound {
    private static final String CAR_POSITION_MARKER = "-";
    private static final String RACE_RESULT_DELIMITER = " : ";
    private static final String ENTER = "\n";

    private final Map<String, Integer> carPositionMap;

    public RaceResultOfRound(Cars cars) {
        this.carPositionMap = new HashMap<>();
        cars.forEach(this::recordRaceResult);
    }

    private void recordRaceResult(Car car) {
        carPositionMap.put(car.getName(), car.getDistance());
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Map.Entry<String, Integer> entry : carPositionMap.entrySet()) {
            int position = entry.getValue();
            maxPosition = Math.max(position, maxPosition);
        }
        return maxPosition;
    }

    public List<String> getWinners(int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : carPositionMap.entrySet()) {
            String carName = entry.getKey();
            if (maxDistance == entry.getValue()) winners.add(carName);
        }
        return winners;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : carPositionMap.entrySet()) {
            String carName = entry.getKey();
            int position = entry.getValue();
            sb.append(carName)
                    .append(RACE_RESULT_DELIMITER)
                    .append(CAR_POSITION_MARKER.repeat(position))
                    .append(ENTER);
        }
        return sb.toString();
    }
}

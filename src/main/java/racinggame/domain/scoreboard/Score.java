package racinggame.domain.scoreboard;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racinggame.domain.car.Car;
import racinggame.domain.car.Cars;
import racinggame.domain.exception.InvalidUnknownCarNameException;

public class Score {

    private final Map<String, Integer> scoreInfo = new LinkedHashMap<>();

    public Score(Cars cars) {
        for (int i = 0; i < cars.getSize(); i++) {
            Car car = cars.getCar(i);
            scoreInfo.put(car.getName(), car.getDistance());
        }
    }

    public Map<String, Integer> getAllScore() {
        return scoreInfo;
    }

    public Integer getScore(String name) {
        Integer distance = scoreInfo.get(name);
        if (distance == null) {
            throw new InvalidUnknownCarNameException();
        }
        return distance;
    }

    public List<String> getWinner() {
        return getWinners(getMaxDistance());
    }

    private int getMaxDistance() {
        int maxDistance = -1;
        for (String name : scoreInfo.keySet()) {
            maxDistance = getMaxDistance(maxDistance, name);
        }
        return maxDistance;
    }

    private int getMaxDistance(int maxDistance, String name) {
        int distance = scoreInfo.get(name);
        if (distance > maxDistance) {
            maxDistance = distance;
        }
        return maxDistance;
    }

    private List<String> getWinners(int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (String name : scoreInfo.keySet()) {
            updateWinners(maxDistance, winners, name);
        }
        return winners;
    }

    private void updateWinners(int maxDistance, List<String> winners, String name) {
        if (scoreInfo.get(name) == maxDistance) {
            winners.add(name);
        }
    }

}

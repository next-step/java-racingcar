package racinggame.domain.scoreboard;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
        Deque<String> winnerDeque = new LinkedList<>();

        for (String name : scoreInfo.keySet()) {
            updateWinner(winnerDeque, name);
        }

        return new ArrayList<>(winnerDeque);
    }

    private void updateWinner(Deque<String> winnerStack, String name) {
        int distance = scoreInfo.get(name);
        removeLoser(winnerStack, distance);

        if (winnerStack.isEmpty() || distance == scoreInfo.get(winnerStack.peek())) {
            winnerStack.add(name);
        }
    }

    private void removeLoser(Deque<String> winnerStack, int distance) {
        while (!winnerStack.isEmpty() && distance > scoreInfo.get(winnerStack.peek())) {
            winnerStack.pop();
        }
    }

}

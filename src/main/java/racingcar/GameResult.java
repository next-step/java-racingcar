package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    List<List<Car>> gameResultList = new ArrayList<>();

    public void addResult(List<Car> resultCarList) {
        gameResultList.add(resultCarList);
    }

    public List<List<Car>> getGameResultList() {
        return gameResultList;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();

        int maxPosition = 0;

        for (Car car : gameResultList.get(gameResultList.size() - 1)) {
            maxPosition = comparePosition(winners, car, maxPosition);
        }

        return winners;
    }

    private int comparePosition(List<String> winners, Car car, int maxPosition) {
        int carPosition = car.getPosition();
        String carName = car.getCarName();

        if (carPosition == maxPosition) {
            winners.add(carName);
        }

        if (carPosition > maxPosition) {
            winners.clear();
            winners.add(carName);
            maxPosition = carPosition;
        }
        return maxPosition;
    }
}

package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private List<String> winners = new ArrayList<>();

    public List<String> getWinners() {
        return winners;
    }

    public List<String> collectWinners(List<Car> cars) {
        int firstWinnerPosition = cars.get(0).getPosition();
        for(Car car : cars) {
            comparePosition(firstWinnerPosition, car);
        }
        return winners;
    }

    void comparePosition(int firstWinnerPosition, Car otherPlayer) {
        if (firstWinnerPosition == (otherPlayer.getPosition())) {
            winners.add(otherPlayer.getName());
        }
    }
}
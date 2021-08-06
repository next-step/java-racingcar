package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerPolicyImpl implements WinnerPolicy {

    @Override
    public List<RacingCar> winnerDecision(List<RacingCar> cars) {
        int winnerDistance = getMaxDistance(cars);
        return getWinners(winnerDistance, cars);
    }

    private int getBigggerNum(int num1, int num2) {
        return Math.max(num1, num2);
    }

    private int getMaxDistance(List<RacingCar> cars) {
        int max = 0;
        for (RacingCar car : cars) {
            int distance = car.showDrivenDistance();
            max = getBigggerNum(max, distance);

        }
        return max;
    }

    private void isWinner(int winnerDistance, RacingCar car, List<RacingCar> winners) {
        if (car.equalsDistance(winnerDistance)) {
            winners.add(car);
        }
    }

    private List<RacingCar> getWinners(int winnerDistance, List<RacingCar> cars) {
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar car : cars) {
            isWinner(winnerDistance, car, winners);
        }
        return winners;
    }
}

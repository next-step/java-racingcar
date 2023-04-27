package racingcar.game;

import racingcar.car.Car;
import racingcar.car.Winners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerDecisionByBigLocations implements WinnerDecisionStrategy {

    @Override
    public Winners decideWinners(List<Car> allParticipants) {
        if (allParticipants.isEmpty()) {
            return new Winners(Collections.emptyList());
        }

        int maxLocation = maxLocation(allParticipants);

        return createWinners(allParticipants, maxLocation);
    }

    private int maxLocation(List<Car> allParticipants) {
        int maxLocation = 0;

        for (Car car : allParticipants) {
            maxLocation = car.max(maxLocation);
        }

        return maxLocation;
    }

    private Winners createWinners(List<Car> cars, int maxLocation) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isWinner(maxLocation)) {
                winners.add(car);
            }
        }

        return new Winners(winners);
    }
}

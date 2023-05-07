package racingcar.game;

import racingcar.car.Car;
import racingcar.car.Position;
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

        Position maxLocation = maxLocation(allParticipants);

        return createWinners(allParticipants, maxLocation);
    }

    private Position maxLocation(List<Car> allParticipants) {
        Position maxPosition = new Position(0);

        for (Car car : allParticipants) {
            maxPosition = car.maxLocation(maxPosition);
        }

        return maxPosition;
    }

    private Winners createWinners(List<Car> cars, Position maxPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }

        return new Winners(winners);
    }
}

package racingcar;

import racingcar.car.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerDecisionByBigLocations implements WinnerDecisionStrategy {

    @Override
    public List<Car> decideWinners(List<Car> allParticipants) {
        if (allParticipants.isEmpty()) {
            return Collections.emptyList();
        }

        final int maxLocation = maxLocation(allParticipants);

        return allParticipants.stream()
                .filter(car -> car.isWinner(maxLocation))
                .collect(Collectors.toList());
    }

    private int maxLocation(List<Car> allParticipants) {
        int maxLocation = 0;

        for (Car car : allParticipants) {
            maxLocation = car.max(maxLocation);
        }

        return maxLocation;
    }

}

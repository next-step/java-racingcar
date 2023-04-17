package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerDecisionByBigLocations implements WinnerDecisionStrategy {

    @Override
    public List<Car> decideWinners(List<Car> allParticipants) {
        if (allParticipants.isEmpty()) return Collections.emptyList();

        List<Car> sortedCars = sortByLocationInDescending(allParticipants);

        int maxLocation = sortedCars.get(0).location();

        return sortedCars.stream()
                .filter(car -> car.location() == maxLocation)
                .collect(Collectors.toList());
    }

    private List<Car> sortByLocationInDescending(List<Car> cars) {
        cars.sort((car1, car2) -> car2.location() - car1.location());

        return cars;
    }

}

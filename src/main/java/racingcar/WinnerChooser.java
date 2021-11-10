package racingcar;

import java.rmi.NoSuchObjectException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerChooser {

    private final int DISTANCE_OF_ZERO = 0;

    List<CarState> carStates;

    public WinnerChooser(List<CarState> carStates) {
        this.carStates = carStates;
    }

    public List<CarState> chooseWinner()  {
        int maxDistance = getMaxDistance();

        if (maxDistance == 0) {
            return Collections.emptyList();
        }

        return carStates.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        int maxDistance;

        try {
            maxDistance = tryGetMaxDistance();
        } catch (NoSuchObjectException excpetion) {
            return DISTANCE_OF_ZERO;
        }

        return maxDistance;
    }

    private int tryGetMaxDistance() throws NoSuchObjectException {
        Comparator<CarState> comparator = Comparator.comparingInt(CarState::getDistance);
        return carStates.stream()
                .max(comparator)
                .orElseThrow(() -> new NoSuchObjectException("There is no max distance"))
                .getDistance();
    }
}

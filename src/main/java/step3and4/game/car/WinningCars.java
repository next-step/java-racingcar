package step3and4.game.car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WinningCars {

    private final Cars cars;

    public WinningCars(Cars cars) {
        this.cars = cars;
    }

    public List<String> winners() {
        final List<String> positionsAndNames = cars.positionsAndNames();

        final Integer fastestCarPosition = fastestCarPosition(positionsAndNames);

        return positionsAndNames.stream()
                .filter(positionAndName -> positionAndName.substring(judgmentIndex(positionAndName))
                        .length() == fastestCarPosition)
                .map(positionAndName -> positionAndName.substring(0, judgmentIndex(positionAndName)))
                .collect(Collectors.toList());
    }

    private Integer fastestCarPosition(List<String> positionsAndNames) {
        return positionsAndNames.stream()
                .map(positionAndName -> positionAndName.substring(judgmentIndex(positionAndName)))
                .map(String::length)
                .max(Comparator.comparingInt(position -> position))
                .orElse(0);
    }

    private int judgmentIndex(String positionAndName) {
        return positionAndName.lastIndexOf(" : ");
    }

}

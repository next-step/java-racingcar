package racing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private final List<Car> carPositions;
    private static List<String> winnerList;

    public RacingGameResult(List<Car> carPositions, List<String> winners) {
        this.carPositions = carPositions;
        this.winnerList = getWinnerCars(getMaxPosition());
    }

    public int getMaxPosition() {
        return carPositions.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get()
                .getPosition();
    }

    public List<String> getWinnerCars(int maxCarPosition) {
        return carPositions.stream()
                .filter(list -> list.getPosition() == maxCarPosition)
                .map(list -> list.getCarName())
                .collect(Collectors.toList());
    }

    public static List<String> getWinnerList() {
        return winnerList;
    }
}

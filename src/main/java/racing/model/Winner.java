package racing.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    public static String getNames(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<Car> winnerCars = getWinnerCars(cars, maxPosition);
        return collectWinnersName(winnerCars);
    }

    private static String collectWinnersName(List<Car> winnerCars) {
        String winnerNames = "";
        for (Car e : winnerCars) winnerNames = winnerNames.concat(e.getName() + ",");
        return winnerNames.substring(0, winnerNames.length() - 1);
    }

    private static List<Car> getWinnerCars(List<Car> cars, int maxPosition) {
        return cars.stream().filter(e -> e.getPosition() == maxPosition).collect(Collectors.toList());
    }

    private static int getMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElseThrow(NullPointerException::new);
    }
}

package step5.domain;

import java.util.List;

public class Winner {
    private static final String NAME_SEPARATOR = ", ";

    public static String getWinner(List<Car> carList) {

        int max = carList.stream().mapToInt(it -> it.location).max().getAsInt();
        String winner = "";
        for (Car car : carList) {
            winner = getWinnerString(car, max, winner);
        }
        return winner;
    }

    private static String getWinnerString(Car car, int max, String winner) {
        if (max == car.location) {
            winner += getWinnerString(car, winner);
        }
        return winner;
    }

    private static String getWinnerString(Car car, String winner) {
        if (!winner.isBlank()) {
            winner += NAME_SEPARATOR;
        }
        winner += car.name;
        return winner;
    }
}

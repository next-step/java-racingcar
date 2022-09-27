package step4;

import java.util.List;

public class Winner {

    private static int max = 0;
    private static String winner = "";
    private static final String NAME_SEPARATOR = ", ";

    public static String getWinner(List<Car> carList) {

        max = carList.stream().mapToInt(it -> it.location).max().getAsInt();

        for (Car car : carList) {
            getWinnerString(car);
        }
        return winner;
    }

    private static void getWinnerString(Car car) {
        if (max == car.location) {
            if (!winner.isBlank()) {
                winner += NAME_SEPARATOR;
            }
            winner += car.name;
        }
    }
}

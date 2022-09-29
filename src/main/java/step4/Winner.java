package step4;

import java.util.List;

public class Winner {
    private static final String NAME_SEPARATOR = ", ";

    public static String getWinner(List<Car> carList) {

        int max = carList.stream().mapToInt(it -> it.location).max().getAsInt();
        String winner = "";
        for (Car car : carList) {
            winner = getWinnerString(car,max,winner);
        }
        return winner;
    }

    private static String getWinnerString(Car car,int max, String winner) {
        if (max == car.location) {
            if (!winner.isBlank()) {
                winner += NAME_SEPARATOR;
            }
            winner += car.name;
        }
        return winner;
    }
}

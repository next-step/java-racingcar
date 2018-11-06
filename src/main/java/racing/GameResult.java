package racing;

import java.util.Collections;
import java.util.List;

public class GameResult {

    private static int WINNER_POSITION_IDX = 0;
    private List<Car> cars;

    public GameResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getWinner() {
        sortingCars();
        int winnerPosition = cars.get(WINNER_POSITION_IDX).getPosition();

        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb = makeWinnerString(winnerPosition, sb, car);
        }

        return getSubstring(sb);
    }

    private String getSubstring(StringBuilder sb) {
        return sb.toString().substring(0, sb.lastIndexOf(","));
    }

    public void sortingCars() {
        Collections.sort(cars);
    }

    private static StringBuilder makeWinnerString(int winnerPosition, StringBuilder sb, Car car) {
        if (car.getPosition() == winnerPosition) {
            sb.append(car.getName()+", ");
        }
        return sb;
    }
}

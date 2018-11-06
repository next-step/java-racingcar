package racing;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private static int WINNER_POSITION_IDX = 0;
    private List<Car> cars = new ArrayList<>();

    public void setResult(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getWinner() {
        cars.sort((o1, o2) -> {
            return makeDescending(o1, o2);
        });

        int winnerPosition = cars.get(WINNER_POSITION_IDX).getPosition();

        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb = makeWinnerString(winnerPosition, sb, car);
        }

        return sb.toString().substring(0, sb.lastIndexOf(","))+"가 최종 우승했습니다.";
    }

    private static int makeDescending(Car o1, Car o2) {
        if (o1.getPosition() > o2.getPosition())
            return -1;
        if (o1.getPosition() < o2.getPosition())
            return 1;
        return 0;
    }

    private static StringBuilder makeWinnerString(int winnerPosition, StringBuilder sb, Car car) {
        if (car.getPosition() == winnerPosition) {
            sb.append(car.getName()+", ");
        }
        return sb;
    }
}

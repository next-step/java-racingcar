package study.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    public static List<Car> findWinner(List<Car> carList) {
        return findWinner(carList, getWinnerPosition(carList));
    }

    private static List<Car> findWinner(List<Car> carList, int winnerPosition) {
        List<Car> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.matchPosition(winnerPosition)) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }

    private static int getWinnerPosition(List<Car> carList) {
        int maxPosition = 0;
        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}

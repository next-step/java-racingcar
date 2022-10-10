package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerChecker {

    public List<String> findWinners(Cars cars) {

        List<String> winnersList = new ArrayList<>();
        int maxPosition = findMaxPosition(cars.getCars());

        for (Car car : cars.getCars()) {
            checkAndPutWinner(winnersList, maxPosition, car);
        }
        return winnersList;

    }

    private void checkAndPutWinner(List<String> winners, int maxPosition, Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    private int findMaxPosition(List<Car> carList) {
        int maxPosition = -1;
        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerExtraction {
    public int getMaxPosition(List<Car> carList) {
        int maxPosition = 0;

        for (Car car : carList) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> getWinners(List<Car> carList, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}

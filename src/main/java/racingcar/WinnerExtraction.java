package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerExtraction {
    public int getMaxPosition(List<Car> carList) {
        int maxPosition = 0;

        for (int i = 0; i < carList.size(); i++) {
            if (maxPosition < carList.get(i).getPosition()) {
                maxPosition = carList.get(i).getPosition();
            }
        }
        return maxPosition;
    }

    public List<Car> getWinners(List<Car> carList, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}

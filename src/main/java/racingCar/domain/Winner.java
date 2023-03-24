package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public List<String> getWinner(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            setWinners(maxPosition, winners, car);
        }
        return winners;
    }

    private void setWinners(int maxPosition, List<String> winners, Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }
}

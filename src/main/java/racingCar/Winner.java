package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public List<String> getWinner(final int maxPosition, List<Car> garage) {
        List<String> winners = new ArrayList<>();
        for (Car car : garage) {
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

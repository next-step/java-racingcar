package homework.week1;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> winners;
    private int winPosition;

    List<String> getWinnersName(List<Car> cars) {
        winners = getWinners(cars);
        List<String> carNames = new ArrayList<>();
        for (Car car : winners) {
            carNames.add(car.getName());
        }
        return carNames;
    }

    private List<Car> getWinners(List<Car> cars) {
        setWinPosition(cars);
        winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(car);
        }
        return winners;
    }

    private void addWinner(Car car) {
        if (car.getPosition() == winPosition) {
            winners.add(car);
        }
    }

    private void setWinPosition(List<Car> cars) {
        for (Car car : cars) {
            winPosition = getMaxNumber(car.getPosition());
        }
    }

    private int getMaxNumber(int value) {
        if (winPosition < value) {
            return value;
        }
        return winPosition;
    }
}

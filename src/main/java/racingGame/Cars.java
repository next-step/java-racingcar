package racingGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        findCoWinner(winners);
        return winners;
    }

    private void findCoWinner(List<String> winners) {
        for (int i = 0; i < cars.size(); i++) {
            checkCoWinner(winners, i);
        }
    }

    private void checkCoWinner(List<String> winners, int i) {
        if (cars.get(i).getPosition() == getMaxPosition())
            winners.add(cars.get(i).getCarName());
    }

    private int getMaxPosition() {
        return getMaxCar().getPosition();
    }

    private Car getMaxCar() {
        return Collections.max(cars);
    }

}

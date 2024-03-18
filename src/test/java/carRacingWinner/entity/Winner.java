package carRacingWinner.entity;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    List<Car> winner;
    public int location(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getLocation() > max)
                max = car.getLocation();
        }
        return max;
    }

    public void saveWinner(Car car) {
        winner.add(car);
    }

    private void createWinner() {
        this.winner = new ArrayList<>();
    }

    public List<Car> printWinner(List<Car> cars) {
        if (winner == null)
            createWinner();
        int maxLocation = location(cars);
        for (Car car : cars) {
            if (car.getLocation() == maxLocation)
                saveWinner(car);
        }
        return winner;
    }
}

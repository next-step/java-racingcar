package step3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Winner {

    private List<Car> winners = new ArrayList<>();
    private int max;

    public int getMax() {
        return max;
    }

    public void addWinner(List<Car> cars) {
        findMax(cars);

        for (Car car : cars) {
            addOrNot(car);
        }
    }

    private void findMax(List<Car> cars) {
        this.max = cars.stream()
                .max(Comparator.comparingInt(Car::getGoCount))
                .get()
                .getGoCount();
    }

    public List<Car> getWinners() {
        return winners;
    }

    private void addOrNot(Car car) {
        if (car.getGoCount() == max) {
            winners.add(car);
        }
    }

    private void setMaxGoCount(Car car) {
        if (max < car.getGoCount()) {
            max = car.getGoCount();
        }
    }

}

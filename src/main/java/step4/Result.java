package step4;

import java.util.*;

public class Result {
    private List<String> winner = new ArrayList<>();

    public void findWinner(List<Car> cars) {
        Car maxValue = cars.stream().max(Comparator.comparing(Car::getPosition)).get();

        for (Car car : cars) {
            addWinner(maxValue, car);
        }
    }

    private void addWinner(Car maxValue, Car car) {
        if (car.getPosition() == maxValue.getPosition()) {
            winner.add(car.getName());
        }
    }

    public List<String> getWinner() {
        return winner;
    }
}

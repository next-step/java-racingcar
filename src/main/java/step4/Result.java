package step4;

import java.util.*;

public class Result {
    private List<String> winner = new ArrayList<>();

    public List<String> findWinner(Cars cars) {
        Car maxValue = cars.findMaxValue();

        for (int i = 0 ; i < cars.getCarsSize() ; i++) {
            addWinner(maxValue, cars.getCar(i));
        }
        return winner;
    }

    private void addWinner(Car maxValue, Car car) {
        if (car.getPosition() == maxValue.getPosition()) {
            winner.add(car.getName());
        }
    }
}

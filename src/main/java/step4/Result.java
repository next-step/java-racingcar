package step4;

import java.util.*;

public class Result {
    private List<String> winner = new ArrayList<>();

    List<String> findWinner(final Cars cars) {
        Car maxValue = cars.findMaxValue();

        for (int i = 0 ; i < cars.getCarsSize() ; i++) {
            addWinner(maxValue, cars.getCar(i));
        }
        return winner;
    }

    void addWinner(Car maxValue, Car car) {
        if (car.getPosition() == maxValue.getPosition()) {
            winner.add(car.getName());
        }
    }
}

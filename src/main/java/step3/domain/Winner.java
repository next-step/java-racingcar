package step3.domain;

import java.util.*;

public class Winner {
    public List<Car> decide(List<Car> carList) {
        return winner(carList, maxPosition(carList));
    }

    private int maxPosition(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .filter(i -> i >= 0)
                .max()
                .orElse(0);
    }

    private List<Car> winner(List<Car> carList, int maxPosition) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() != maxPosition) {
                carList.remove(i);
            }
        }
        return carList;
    }
}
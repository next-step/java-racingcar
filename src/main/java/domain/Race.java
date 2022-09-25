package domain;

import util.CommonUtil;

import java.util.LinkedList;
import java.util.List;

public class Race {

    private final List<Car> cars;
    private final int turns;

    public Race(List<Car> cars, int turns) {
        this.cars = cars;
        this.turns = turns;
    }

    public static List<Car> getWinner(List<Car> cars) {

        Car currentMax = cars.get(0);

        List<Car> winners = new LinkedList<>();
        winners.add(currentMax);

        for (int i = 1; i < cars.size(); i++) {
            if (currentMax.getForward() < cars.get(i).getForward()) {
                winners.clear();
                currentMax = cars.get(i);
                winners.add(currentMax);
                continue;
            }
            if (currentMax.getForward() == cars.get(i).getForward()) {
                winners.add(cars.get(i));
            }
        }
        return winners;
    }

    public int getTurns() {
        return turns;
    }

}

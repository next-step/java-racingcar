package domain;

import util.CommonUtil;

import java.util.LinkedList;
import java.util.List;

public class Race {

    private final List<Car> cars;
    private final int turns;

    CommonUtil util = new CommonUtil();

    public Race(List<Car> cars, int turns) {
        this.cars = cars;
        this.turns = turns;
    }

    public void beginTurn(List<Car> cars) {
        for (Car car : cars) {
            getEachTurn(car);
        }
    }

    public void getEachTurn(Car car) {
        if (util.getRandomNumber() > 6) {
            car.getSteps().append("-");
            car.addForward();
        }
    }

    public List<Car> getWinner(Race race) {
        List<Car> cars = race.getCars();
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

    public List<Car> getCars() {
        return cars;
    }

    public int getTurns() {
        return turns;
    }

}

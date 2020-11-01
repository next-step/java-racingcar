package step3.game;

import step3.car.Car;
import step3.strategy.MoveStrategy;

import java.util.*;


public abstract class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final Map<Integer, List<Integer>> gameHistory = new HashMap<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    private void logGameHistory(int round){
        List<Integer> list = new ArrayList<>();
        cars.forEach(c-> list.add(c.currentProgress()));
        gameHistory.put(round, list);
    }

    public void notifyCars(int round) {
        cars.forEach(Car::go);
        logGameHistory(round);
    }

    public Optional<List<Integer>> getResultByRound(int round) {
        return Optional.ofNullable(gameHistory.get(round));
    }
    public Map<Integer, List<Integer>> getResultAll() {
        return gameHistory;
    }

    public abstract void addCarList(int number);
    public abstract void addCarList(int number, MoveStrategy moveStrategy);

    public abstract void execute(RacingInfomation racingInfomation, MoveStrategy moveStrategy);
}

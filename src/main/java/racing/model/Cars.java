package racing.model;

import racing.model.move.MoveStrategy;
import racing.model.move.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] names) {
        cars = new ArrayList<>();
        createCarsByName(names);
    }

    public List<Car> move(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }


    private List<Car> createCarsByName(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

        cars = Collections.unmodifiableList(cars);

        return cars;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            addWinner(winners, car);
        }

        return winners;
    }

    private void addWinner(List<Car> winners, Car car) {
        int winnerScore = getWinnerScore();

        if (car.isSamePosition(winnerScore)) {
            winners.add(car);
        }
    }

    private int getWinnerScore() {
        Car car = Collections.max(cars);
        int winnerScore = car.getPosition();

        return winnerScore;
    }

}

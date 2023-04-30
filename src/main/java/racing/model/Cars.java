package racing.model;

import racing.model.move.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;
    private MoveStrategy moveStrategy;

    public Cars() {
        this.cars = new ArrayList<>();
        this.moveStrategy = new MoveStrategy() {
            @Override
            public boolean move() {
                return true;
            }
        };
    }

    public Cars(int number, MoveStrategy moveStrategy) {
        this.cars = new ArrayList<>();
        createCars(number);
        this.moveStrategy = moveStrategy;
    }

    public Cars(String[] names, MoveStrategy moveStrategy) {
        cars = new ArrayList<>();
        createCarsByName(names);
        this.moveStrategy = moveStrategy;
    }

    public List<Car> move() {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> createCars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }

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

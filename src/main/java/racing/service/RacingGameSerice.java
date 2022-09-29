package racing.service;

import racing.model.Car;
import racing.model.DefaultCar;
import racing.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGameSerice {
    private List<Car> cars;

    public RacingGameSerice(String[] names) {
        cars = generateCar(names);
    }

    private void CarMoveProcess(Car car) {
        if (car.canMove(RandomGenerator.generate())) {
            car.move();
        }
    }

    public List<Car> generateCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new DefaultCar(name));
        }
        return cars;
    }

    public List<Car> getWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int winnerPosition = 0;
        for (Car car : cars) {
            winners = findWinners(winners, winnerPosition, car);
            winnerPosition = changeWinnerPosition(winnerPosition, car);
        }
        return winners;
    }

    private int changeWinnerPosition(int winnerPosition, Car car) {
        if (car.getPosition() > winnerPosition) {
            winnerPosition = car.getPosition();
        }
        return winnerPosition;
    }

    private List<Car> findWinners(List<Car> winners, int winnerPosition, Car car) {
        if (car.getPosition() == winnerPosition) {
            winners.add(car);
        }
        if (car.getPosition() > winnerPosition) {
            winners = new ArrayList<>();
            winners.add(car);

        }
        return winners;
    }

    public List<Car> getWinner() {
        return getWinner(this.cars);
    }

    public List<Car> race() {
        for (Car car : cars) {
            CarMoveProcess(car);
        }
        return this.cars;
    }
}

package racingcar.domain;

import racingcar.strategy.MovingStrategy;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.application.CarConstant.CAR_DEFAULT_STATE;

public class Cars {

    private final List<Car> cars;
    private State max = new State(CAR_DEFAULT_STATE);

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(List<Car> cars, State max) {
        this.cars = cars;
        this.max = max;
    }

    public void goingTry(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.increaseState(movingStrategy);
            max = car.getState().max(max);
            OutputView.carState(car);
        }
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            findWinners(winners, car);
        }

        return winners;
    }

    public void findWinners(List<String> winners, Car car) {
        if (car.isWinner(this.max)) {
            winners.add(car.getName());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public State getMax() {
        return max;
    }
}

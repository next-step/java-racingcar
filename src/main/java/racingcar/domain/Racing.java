package racingcar.domain;

import common.StringValidation;
import racingcar.strategy.MovingStrategy;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.application.CarConstant.*;

public class Racing {

    private final List<Car> cars;
    private final int tryCount;
    private final MovingStrategy movingStrategy;
    private final List<String> winners = new ArrayList<>();
    private int max = 0;


    public Racing(int carCount, int tryCount, MovingStrategy movingStrategy) {
        this.cars = new ArrayList<>(makeCar(carCount));
        this.tryCount = tryCount;
        this.movingStrategy = movingStrategy;
    }

    public Racing(String[] carNames, int tryCount, MovingStrategy movingStrategy) throws IllegalArgumentException {
        this.cars = new ArrayList<>(makeCar(carNames));
        this.tryCount = tryCount;
        this.movingStrategy = movingStrategy;
    }

    public List<Car> makeCar(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public List<Car> makeCar(String[] carNames) throws IllegalArgumentException {
        StringValidation.isEmptyOrNull(carNames, EXCEPTION_CAR_NAME_IS_EMPTY_OR_NULL);
        StringValidation.isLimitOver(carNames, CAR_NAME_MAX_LENGTH, EXCEPTION_CAR_NAME_LIMIT_MESSAGE);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void goingTry() {
        for (Car car : cars) {
            car.increaseState(movingStrategy);
            max = Math.max(car.getState(), max);
            OutputView.print(car);
        }
        OutputView.print();
    }

    public void start() {
        OutputView.print("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            this.goingTry();
        }
        this.result();
    }

    public void result() {
        for (Car car : cars) {
            this.findWinner(car, max);
        }
        OutputView.print(winners, "가 최종 우승헀습니다.");
    }

    private void findWinner(Car car, int max) {
        if (car.getState() == max) {
            this.winners.add(car.getName());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMax() {
        return max;
    }

    public List<String> getWinners() {
        return winners;
    }
}

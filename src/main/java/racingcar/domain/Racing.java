package racingcar.domain;

import racingcar.strategy.MovingStrategy;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final int tryCount;
    private final MovingStrategy movingStrategy;


    public Racing(int carCount, int tryCount, MovingStrategy movingStrategy) {
        this.cars = new ArrayList<>(makeCar(carCount));
        this.tryCount = tryCount;
        this.movingStrategy = movingStrategy;
    }

    public Racing(String[] carNames, int tryCount, MovingStrategy movingStrategy) {
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

    public List<Car> makeCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void goingTry() {
        for (Car car : cars) {
            car.increaseState(movingStrategy);
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


    }

    public List<Car> getCars() {
        return cars;
    }
}
